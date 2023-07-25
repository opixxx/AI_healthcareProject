import cv2
import mediapipe as mp
import os
import random


mp_pose = mp.solutions.pose
attention_dot = [12, 14, 16, 24, 26, 28, 30, 32]
draw_line = [[12, 14], [14, 16], [12, 24], [24, 26], [26, 28], [28, 30], [30, 32]]


# img = frame, cap = video

def show_skeleton(video_path, interval, attention_dot, draw_line):
    xy_list_list, xy_list_list_flip = [], []
    cv2.destroyAllWindows()
    pose = mp_pose.Pose(static_image_mode=True, model_complexity=1,
                        enable_segmentation=False, min_detection_confidence=0.5)  #0.3으로 했었음
    cap = cv2.VideoCapture(video_path)
    if cap.isOpened():
        cnt = 0
        while True:
            ret, img = cap.read()
            if cnt == interval and ret == True:
                cnt = 0
                xy_list, xy_list_flip = [], []
                img = cv2.resize(img, (640, 640))
                results = pose.process(cv2.cvtColor(img, cv2.COLOR_BGR2RGB))
                if not results.pose_landmarks: continue
                idx = 0
                draw_line_dic = {}
                for x_and_y in results.pose_landmarks.landmark:
                    if idx in attention_dot:
                        xy_list.append(x_and_y.x)
                        xy_list.append(x_and_y.y)
                        xy_list_flip.append(1 - x_and_y.x)
                        xy_list_flip.append(x_and_y.y)
                        x, y = int(x_and_y.x * 640), int(x_and_y.y * 640)
                        draw_line_dic[idx] = [x, y]
                    idx += 1
                xy_list_list.append(xy_list)
                xy_list_list_flip.append(xy_list_flip)
                for line in draw_line:
                    x1, y1 = draw_line_dic[line[0]][0], draw_line_dic[line[0]][1]
                    x2, y2 = draw_line_dic[line[1]][0], draw_line_dic[line[1]][1]
                    img = cv2.line(img, (x1, y1), (x2, y2), (0, 255, 0), 4)
                cv2.imshow('Landmark Image', img)
                cv2.waitKey(1)
            elif ret == False:
                break
            cnt += 1
    cap.release()
    cv2.destroyAllWindows()
    return xy_list_list + xy_list_list_flip


video_path = 'c:/users/JunHyeok/aidata'
video_name_list = os.listdir(video_path)
dataset = []
length = 20
interval = 1
for video_name in video_name_list:
    if 'squart' in video_name:
        label = 0
    else:
        label = 1
    skel_data = show_skeleton('{}/{}'.format(video_path, video_name), interval, attention_dot, draw_line)
    for idx in range(0, len(skel_data), int(length / 2)):
        seq_list = skel_data[idx:idx + length]
        if len(seq_list) == length:
            dataset.append({'key': label, 'value': seq_list})
random.shuffle(dataset)
# print('dataset의 길이 : {}'.format(len(dataset)))
