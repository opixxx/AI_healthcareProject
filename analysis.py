from flask import Flask, request, jsonify
from PIL import Image
import tensorflow as tf
import cv2
import numpy as np


#model load
model = tf.keras.models.load_model('saved_models/CNN_model_h5')

app = Flask(__name__)

def process_single_video(video_file):
    # 비디오에서 프레임 추출
    cap = cv2.VideoCapture(video_file)
    frames = []
    while cap.isOpened():
        ret, frame = cap.read()
        if not ret:
            break
        frame = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)  # 흑백 변환
        frame = cv2.resize(frame, (64, 64))               # 크기 조절
        frames.append(frame)
    cap.release()

    # numpy 배열로 변환 및 정규화
    return np.array(frames, dtype=np.float32).reshape(-1, 64, 64, 1) / 255.0


def process_video():
    # 사용자로부터 받은 비디오 데이터
    video_file = request.files.get('video')

    # 비디오 전처리
    processed_frames = process_single_video(video_file)

    # 모델 예측
    predictions = model.predict(processed_frames)

    # 예측 결과를 바탕으로 조언 생성 (예: 모든 프레임의 평균값 계산)
    avg_prediction = np.mean(predictions)

    if avg_prediction > 0.5:
        advice = "올바른 자세입니다."
    else:
        advice = "자세를 조정하세요."

    # JSON 응답 반환
    return jsonify({'advice': advice})

    app.add_url_rule('/analysis', view_func=analyze_video, methods=['POST'])


if __name__ == '__main__':
    app.run(debug=True)


