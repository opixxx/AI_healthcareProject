import mediapipe as mp
import glob
import cv2
import numpy as np
from sklearn.model_selection import train_test_split


# 스켈레톤을 그리는 함수
def draw_skeleton(frame, attention_dot, draw_line):
    mp_pose = mp.solutions.pose
    pose = mp_pose.Pose(static_image_mode=True, model_complexity=1,
                        enable_segmentation=False, min_detection_confidence=0.5)
    frame = cv2.resize(frame, (640, 640))
    results = pose.process(cv2.cvtColor(frame, cv2.COLOR_BGR2RGB))
    if not results.pose_landmarks:
        return frame

    draw_line_dic = {}
    for idx, x_and_y in enumerate(results.pose_landmarks.landmark):
        if idx in attention_dot:
            x, y = int(x_and_y.x * 640), int(x_and_y.y * 640)
            draw_line_dic[idx] = [x, y]

    for line in draw_line:
        x1, y1 = draw_line_dic[line[0]]
        x2, y2 = draw_line_dic[line[1]]
        frame = cv2.line(frame, (x1, y1), (x2, y2), (0, 255, 0), 4)

    return frame


# 동영상 처리 및 라벨링 함수
def process_videos(video_paths, label, attention_dot, draw_line):
    X, y = [], []
    for video_path in video_paths:
        cap = cv2.VideoCapture(video_path)
        while cap.isOpened():
            ret, frame = cap.read()
            if not ret:
                break

            # 스켈레톤 그리기
            frame = draw_skeleton(frame, attention_dot, draw_line)
            frame = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)  # 흑백 변환
            frame = cv2.resize(frame, (64, 64))  # 크기 조절
            X.append(frame)
            y.append(label)
        cap.release()
    return X, y


attention_dot = [12, 24, 26, 28, 30, 32]
draw_line = [[12, 24], [24, 26], [26, 28], [28, 30], [30, 32]]

good_videos = glob.glob('C:/Users/JunHyeok/aidata/good/*.mp4')
bad_videos = glob.glob('C:/Users/JunHyeok/aidata/bad/*.mp4')

X_good, y_good = process_videos(good_videos, 1, attention_dot, draw_line)
X_bad, y_bad = process_videos(bad_videos, 0, attention_dot, draw_line)

X = X_good + X_bad
y = y_good + y_bad

# numpy 배열로 변환 및 정규화
X = np.array(X, dtype=np.float32).reshape(-1, 64, 64, 1) / 255.0
y = np.array(y, dtype=np.float32)

# 데이터 분할
X_temp, X_test, y_temp, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
X_train, X_val, y_train, y_val = train_test_split(X_temp, y_temp, test_size=0.25, random_state=42)
