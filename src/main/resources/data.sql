insert into exercise (name) values ('체스트 프레스'),
    ('인클라인 벤치 프레스 머신'),
    ('인클라인 벤치 프레스'),
    ('벤치 프레스'),
    ('덤벨 벤치 프레스'),
    ('덤벨 인클라인 벤치 프레스'),
    ('푸쉬업'),
    ('딥스'),
    ('펙덱 플라이 머신'),
    ('케이블 크로스 오버'),
    ('숄더 프레스 머신'),
    ('덤벨 숄더 프레스'),
    ('바벨 숄더 프레스'),
    ('사이드 래터럴 레이즈'),
    ('바벨 프론트 레이즈'),
    ('덤벨 프론트 레이즈'),
    ('밀리터리 프레스'),
    ('리버스 펙덱 플라이'),
    ('벤트 오버 레터럴 레이즈'),
    ('렛 풀 다운'),
    ('바벨 로우'),
    ('비하인드 넥 풀 다운'),
    ('덤벨 풀 오버'),
    ('어시스트 풀업'),
    ('원암 덤벨 로우'),
    ('루마니안 데드리프트'),
    ('언더 그립 랫 풀 다운'),
    ('티바 로우'),
    ('케이블 풀 오버'),
    ('맨몸 스쿼트'),
    ('맨몸 런지'),
    ('레그 익스텐션'),
    ('레그 컬'),
    ('바벨 스쿼트'),
    ('레그 프레스'),
    ('힙 쓰러스터'),
    ('밀리터리 프레스'),
    ('바벨 컬'),
    ('덤밸 킥백'),
    ('케이블 푸쉬 다운'),
    ('시티드 로우'),
    ('덤벨 컬'),
    ('덤벨 오버헤드 익스텐션'),
    ('스쿼트'),
    ('데드 리프트'),
    ('팔 벌려 높이 뛰기'),
    ('버피 테스트'),
    ('마운틴 클라이머'),
    ('크런치'),
    ('레그레이즈'),
    ('사이드 스탭'),
    ('점프 스쿼트'),
    ('크로스 니업'),
    ('카프 레이즈'),
    ('이너 타이 머신'),
    ('아웃 타이 머신'),
    ('덤벨 플라이'),
    ('라잉 트라이셉스 익스텐션'),
    ('풀업'),
    ('해머 컬'),
    ('케이블 프론트 레이즈'),
    ('핵 스쿼트 머신'),
    ('암 컬 머신'),
    ('스미스 머신 스쿼트'),
    ('스미스 머신 런지'),
    ('와이드 풀 다운 머신'),
    ('업라이트 로우');

INSERT INTO routine (routine_id, version, level, day_count) VALUES
    (1, 1,'BEGINNER', 'THREE'),
    (2, 2,'BEGINNER', 'THREE'),

    (3, 1,'BEGINNER', 'FOUR'),
    (4, 2,'BEGINNER', 'FOUR'),

    (5, 1,'BEGINNER', 'FIVE'),
    (6, 2,'BEGINNER', 'FIVE'),

    (7, 1, 'INTERMEDIATE', 'THREE'),
    (8, 2, 'INTERMEDIATE', 'THREE'),

    (9, 1, 'INTERMEDIATE', 'FOUR'),
    (10, 2, 'INTERMEDIATE', 'FOUR'),

    (11, 1, 'INTERMEDIATE', 'FIVE'),
    (12, 2, 'INTERMEDIATE', 'FIVE');

insert into routine_detail (routine_id, day, exercise_id, sets, reps) values
    -- 초보 3일 version 1
    (1, 1, 45, 3, 10),
    (1, 1, 24, 3, 10),
    (1, 1, 1, 3, 10),
    (1, 1, 11, 3, 10),
    (1, 1, 35, 3, 15),
    (1, 1, 32, 3, 15),
    (1, 1, 33, 3, 15),
    (1, 2, 46, 1, 25),
    (1, 2, 47, 1, 12),
    (1, 2, 48, 1, 25),
    (1, 2, 49, 1, 15),
    (1, 2, 7, 1, 10),
    (1, 2, 50, 1, 10),
    (1, 2, 44, 1, 20),
    (1, 2, 51, 1, 20),
    (1, 2, 52, 1, 15),
    (1, 2, 53, 1, 15),
    (1, 3, 21, 4, 12),
    (1, 3, 24, 4, 12),
    (1, 3, 1, 5, 12),
    (1, 3, 8, 4, 12),
    (1, 3, 44, 5, 12),
    (1, 3, 54, 3, 10),
    -- 초보 3일 version 2
    (2, 1, 24, 5, 12),
    (2, 1, 23, 3, 12),
    (2, 1, 37, 3, 12),
    (2, 1, 14, 4, 20),
    (2, 1, 32, 4, 12),
    (2, 1, 33, 4, 12),
    (2, 1, 50, 3, 10),
    (2, 2, 46, 1, 25),
    (2, 2, 47, 1, 12),
    (2, 2, 48, 1, 25),
    (2, 2, 49, 1, 15),
    (2, 2, 7, 1, 10),
    (2, 2, 50, 1, 10),
    (2, 2, 44, 1, 20),
    (2, 2, 51, 1, 20),
    (2, 3, 4, 4, 12),
    (2, 3, 6, 4, 12),
    (2, 3, 9, 3, 15),
    (2, 3, 16, 4, 15),
    (2, 3, 42, 3, 15),
    (2, 3, 40, 3, 15),
    (2, 3, 44, 4, 12),
    (2, 3, 31, 3, 20),
    -- 초보 4일 verison 1
    (3, 1, 4, 5, 12),
    (3, 1, 6, 4, 10),
    (3, 1, 14, 4, 12),
    (3, 1, 11, 4, 12),
    (3, 1, 40, 3, 10),
    (3, 2, 30, 3, 20),
    (3, 2, 52, 3, 20),
    (3, 2, 31, 4, 20),
    (3, 2, 33, 4, 15),
    (3, 2, 36, 3, 15),
    (3, 3, 45, 5, 12),
    (3, 3, 24, 4, 10),
    (3, 3, 18, 4, 15),
    (3, 3, 19, 4, 15),
    (3, 3, 38, 3, 10),
    (3, 4, 44, 5, 10),
    (3, 4, 35, 5, 10),
    (3, 4, 32, 4, 12),
    (3, 4, 33, 4, 12),
    (3, 4, 50, 3, 10),
    -- 초보 4일 version 2
    (4, 1, 29, 4, 12),
    (4, 1, 24, 4, 10),
    (4, 1, 4, 4, 12),
    (4, 1, 9, 4, 15),
    (4, 1, 11, 3, 12),
    (4, 1, 39, 3, 10),
    (4, 2, 55, 4, 15),
    (4, 2, 56, 4, 15),
    (4, 2, 44, 5, 10),
    (4, 2, 32, 3, 15),
    (4, 2, 31, 4, 20),
    (4, 3, 45, 5, 12),
    (4, 3, 28, 4, 10),
    (4, 3, 5, 4, 12),
    (4, 3, 9, 4, 15),
    (4, 3, 14, 4, 20),
    (4, 3, 38, 3, 10),
    (4, 4, 32, 4, 15),
    (4, 4, 33, 4, 15),
    (4, 4, 35, 5, 12),
    (4, 4, 52, 4, 15),
    (4, 4, 50, 3, 10),
    -- 초보 5일 루틴 version 1
    (5, 1, 1, 4, 12),
    (5, 1, 2, 4, 12),
    (5, 1, 11, 4, 12),
    (5, 1, 14, 5, 20),
    (5, 1, 39, 3, 12),
    (5, 2, 24, 4, 12),
    (5, 2, 41, 4, 12),
    (5, 2, 18, 5, 20),
    (5, 2, 26, 4, 12),
    (5, 2, 38, 3, 12),
    (5, 3, 30, 5, 20),
    (5, 3, 31, 5, 20),
    (5, 3, 32, 5, 20),
    (5, 3, 33, 5, 20),
    (5, 4, 7, 4, 15),
    (5, 4, 8, 4, 15),
    (5, 4, 9, 4, 20),
    (5, 4, 12, 4, 12),
    (5, 4, 39, 3, 12),
    (5, 5, 20, 4, 12),
    (5, 5, 21, 4, 12),
    (5, 5, 19, 5, 20),
    (5, 5, 26, 4, 12),
    (5, 5, 38, 3, 12),
    -- 초보 5일 version 2
    (6, 1, 9, 4, 20),
    (6, 1, 4, 4, 12),
    (6, 1, 3 ,4, 12),
    (6, 1, 12, 4, 12),
    (6, 1, 17, 4, 12),
    (6, 2, 29, 3, 20),
    (6, 2, 20, 4, 12),
    (6, 2, 41, 4, 12),
    (6, 2, 42, 3, 20),
    (6, 2, 43, 3, 20),
    (6, 3, 32, 4, 15),
    (6, 3, 44, 4, 12),
    (6, 3, 33, 4, 15),
    (6, 3, 14, 5, 20),
    (6, 3, 18, 4, 20),
    (6, 4, 7, 5, 20),
    (6, 4, 1, 4, 12),
    (6, 4, 2, 4, 12),
    (6, 4, 11, 4, 12),
    (6, 4, 12, 4, 12),
    (6, 5, 20, 4, 12),
    (6, 5, 25, 4, 12),
    (6, 5, 24, 4, 10),
    (6, 5, 38, 3, 15),
    (6, 5, 40, 3, 15),
    -- 중급 3일 verison 1
    (7, 1, 9, 4, 15),
    (7, 1, 3, 4, 12),
    (7, 1, 6, 4, 12),
    (7, 1, 57, 4, 15),
    (7, 1, 1, 4, 12),
    (7, 1, 16, 4, 15),
    (7, 1, 11, 4, 12),
    (7, 1, 58, 3, 10),
    (7, 2, 55, 4, 12),
    (7, 2, 56, 4, 12),
    (7, 2, 32, 4, 12),
    (7, 2, 44, 4, 12),
    (7, 2, 33, 4, 12),
    (7, 2, 35, 4, 12),
    (7, 2, 31, 4, 20),
    (7, 2, 50, 3, 15),
    (7, 3, 45, 4, 12),
    (7, 3, 21, 4, 12),
    (7, 3, 59, 4, 10),
    (7, 3, 20, 4, 12),
    (7, 3, 14, 4, 20),
    (7, 3, 18, 4, 20),
    (7, 3, 42, 3, 10),
    (7, 3, 60, 3, 10),
    -- 중급 3일 version 2
    (8, 1, 4, 4, 12),
    (8, 1, 10, 4, 12),
    (8, 1, 8, 4, 12),
    (8, 1, 6, 4, 12),
    (8, 1, 13, 4, 12),
    (8, 1, 61, 4, 20),
    (8, 1, 40, 3, 10),
    (8, 1, 58, 3, 10),
    (8, 2, 32, 4, 12),
    (8, 2, 44, 4, 12),
    (8, 2, 35, 4, 12),
    (8, 2, 62, 4, 12),
    (8, 2, 33, 4, 12),
    (8, 2, 36, 4, 12),
    (8, 2, 31, 4, 20),
    (8, 3, 29, 4, 20),
    (8, 3, 59, 4, 12),
    (8, 3, 45, 4, 12),
    (8, 3, 41, 4, 12),
    (8, 3, 28, 4, 12),
    (8, 3, 14, 4, 20),
    (8, 3, 18, 4, 20),
    (8, 3, 38, 3, 10),
    -- 중급 4일 version 1
    (9, 1, 9, 4, 20),
    (9, 1, 4, 4, 12),
    (9, 1, 6, 4, 12),
    (9, 1, 1, 4, 12),
    (9, 1, 10, 4, 15),
    (9, 1, 8, 3, 12),
    (9, 1, 40, 3, 10),
    (9, 2, 29, 4, 15),
    (9, 2, 45, 4, 12),
    (9, 2, 21, 4, 12),
    (9, 2, 20, 4, 12),
    (9, 2, 24, 4, 12),
    (9, 2, 63, 3, 10),
    (9, 3, 55, 4, 20),
    (9, 3, 56, 4, 20),
    (9, 3, 35, 5, 12),
    (9, 3, 62, 5, 12),
    (9, 3, 64, 4, 12),
    (9, 3, 65, 4, 12),
    (9, 3, 42, 3, 10),
    (9, 3, 58, 3, 10),
    (9, 4, 37, 4, 12),
    (9, 4, 12, 4, 12),
    (9, 4, 11, 4, 12),
    (9, 4, 14, 4, 20),
    (9, 4, 18, 4, 20),
    (9, 4, 19, 4, 15),
    -- 중급 4일 version 2
    (10, 1, 3, 4, 12),
    (10, 1, 2, 4, 12),
    (10, 1, 57, 5, 15),
    (10, 1, 5, 4, 12),
    (10, 1, 8, 4, 15),
    (10, 1, 10, 4, 15),
    (10, 1, 58, 4, 15),
    (10, 2, 29, 3, 20),
    (10, 2, 59, 4, 12),
    (10, 2, 20, 4, 12),
    (10, 2, 66, 4, 12),
    (10, 2, 41, 4, 12),
    (10, 2, 25, 4, 15),
    (10, 2, 60, 3, 10),
    (10, 2, 42, 3, 10),
    (10, 3, 44, 4, 12),
    (10, 3, 62, 4, 12),
    (10, 3, 32, 4, 12),
    (10, 3, 33, 4, 12),
    (10, 3, 35, 4, 12),
    (10, 3, 36, 4, 12),
    (10, 3, 42, 3, 12),
    (10, 3, 40, 3, 12),
    (10, 4, 18, 5, 20),
    (10, 4, 19, 5, 15),
    (10, 4, 67, 4, 12),
    (10, 4, 14, 4, 12),
    (10, 4, 12, 5, 12),
    (10, 4, 11, 5, 12);














