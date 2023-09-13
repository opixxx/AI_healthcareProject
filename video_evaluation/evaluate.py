import cv2
import numpy as np
from keras.models import load_model

model_path = 'C:/Users/JunHyeok/PycharmProjects/pythonProject3/model/CNN_model_h5'
model = load_model(model_path)
def evaluate_squat(video_path):
    cap = cv2.VideoCapture(video_path)

    # 프레임 저장을 위한 리스트
    frames = []

    while cap.isOpened():
        ret, frame = cap.read()
        if not ret:
            break
        frame = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)  # 흑백 변환
        frame = cv2.resize(frame, (64, 64))  # 크기 조절
        frames.append(frame)

    cap.release()

    # numpy 배열로 변환 및 정규화
    input_data = np.array(frames, dtype=np.float32).reshape(-1, 64, 64, 1) / 255.0

    predictions = model.predict(input_data)

    # 각 프레임별 예측값의 평균을 구하여 전체 영상의 예측값 결정
    avg_prediction = np.mean(predictions)

    if avg_prediction > 0.5:
        return "Good Squat"
    else:
        return "Bad Squat"

video_path = 'C:/Users/JunHyeok/aidata/test/squat_test2.mp4'
result = evaluate_squat(video_path)
print(result)
