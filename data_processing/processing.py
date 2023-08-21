import glob

import cv2

import numpy as np
from sklearn.model_selection import train_test_split


# 동영상 경로
good_videos =glob.glob('C:/Users/82102/Desktop/aidata/good_squat/*.mp4')
bad_videos = glob.glob('C:/Users/82102/Desktop/aidata/bad_squat/*.mp4')

X = []
y = []
# 동영상에서 프레임 추출 및 라벨링 함수
def process_videos(video_paths, label):
    for video_path in video_paths:
        cap = cv2.VideoCapture(video_path)
        while cap.isOpened():
            ret, frame = cap.read()
            if not ret:
                break
            frame = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)  # 흑백 변환
            frame = cv2.resize(frame, (64, 64))               # 크기 조절
            X.append(frame)
            y.append(label)
        cap.release()

# 좋은 자세와 나쁜 자세 동영상 처리
process_videos(good_videos, 1)
process_videos(bad_videos, 0)

# numpy 배열로 변환 및 정규화
X = np.array(X, dtype=np.float32).reshape(-1, 64, 64, 1) / 255.0
y = np.array(y, dtype=np.float32)

# 데이터 분할
X_temp, X_test, y_temp, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
X_train, X_val, y_train, y_val = train_test_split(X_temp, y_temp, test_size=0.25, random_state=42)

