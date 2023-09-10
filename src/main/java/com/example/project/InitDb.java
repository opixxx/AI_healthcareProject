package com.example.project;

import com.example.project.domain.RoutineFinal;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInitBeginnerThree1();
        initService.dbInitBeginnerThree2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        // 초보 3일 version 1
        public void dbInitBeginnerThree1() {
            // Day 1 Routines
            addRoutineFinal(1, "데드리프트", 4, 12);
            addRoutineFinal(1, "어시스트 풀업", 3, 10);
            addRoutineFinal(1, "벤치 프레스", 4, 12);
            addRoutineFinal(1, "머신 숄더프레스", 4, 10);
            addRoutineFinal(1, "레그프레스", 4, 12);
            addRoutineFinal(1, "레그익스텐션", 3, 12);
            addRoutineFinal(1, "레그컬", 3, 12);
            // Day 2 Routines
            addRoutineFinal(2, "팔벌려높이뛰기", 1, 20);
            addRoutineFinal(2, "버피테스트", 1, 10);
            addRoutineFinal(2, "마운틴 클라이머", 1, 20);
            addRoutineFinal(2, "크런치", 1, 15);
            addRoutineFinal(2, "팔굽혀펴기", 1, 10);
            addRoutineFinal(2, "레그레이즈", 1, 10);
            addRoutineFinal(2, "스쿼트", 1, 20);
            addRoutineFinal(2, "사이드 스탭", 1, 20);
            addRoutineFinal(2, "점프 스쿼트", 1, 15);
            addRoutineFinal(2, "점핑잭", 1, 20);
            addRoutineFinal(2, "크로스 니업", 1, 20);
            // Day 3 Routines
            addRoutineFinal(3, "바벨 로우", 4, 12);
            addRoutineFinal(3, "어시스트 풀업", 4, 10);
            addRoutineFinal(3, "체스트 프레스 머신", 4, 12);
            addRoutineFinal(3, "벤치 딥스", 4, 12);
            addRoutineFinal(3, "바벨 스쿼트", 5, 12);
            addRoutineFinal(3, "카프레이즈", 3, 10);
        }
        public void dbInitBeginnerThree2() {
            // Day 1
            addRoutineFinal(1, "풀업", 3, 8);
            addRoutineFinal(1, "바벨 로우", 4, 12);
            addRoutineFinal(1, "밀리터리 프레스", 4, 12);
            addRoutineFinal(1, "사이드 레터럴 레이즈", 3, 20);
            addRoutineFinal(1, "레그 익스텐션", 4, 12);
            addRoutineFinal(1, "레그 컬", 4, 12);
            addRoutineFinal(1, "행잉 레그레이즈", 3, 10);
            // Day 2
            addRoutineFinal(2, "팔벌려높이뛰기", 1, 30);
            addRoutineFinal(2, "버피테스트", 1, 12);
            addRoutineFinal(2, "마운틴 클라이머", 1, 25);
            addRoutineFinal(2, "크런치", 1, 20);
            addRoutineFinal(2, "푸쉬업", 1, 10);
            addRoutineFinal(2, "레그레이즈", 1, 10);
            addRoutineFinal(2, "사이드 스탭", 1, 20);
            addRoutineFinal(2, "점프 스쿼트", 1, 20);
            addRoutineFinal(2, "점핑잭", 1, 20);
            addRoutineFinal(2, "크로스 니업", 1, 20);
            // Day 3
            addRoutineFinal(3, "벤치 프레스", 5, 12);
            addRoutineFinal(3, "인클라인 덤벨 프레스", 4, 12);
            addRoutineFinal(3, "버터플라이 머신", 3, 15);
            addRoutineFinal(3, "덤벨 프론트 레이즈", 4, 20);
            addRoutineFinal(3, "덤벨 컬", 3, 10);
            addRoutineFinal(3, "라잉 트라이셉스 익스텐션", 3, 10);
            addRoutineFinal(3, "바벨 스쿼트", 4, 12);
            addRoutineFinal(3, "맨몸 런지", 3, 20);
        }
        private void addRoutineFinal(int day, String exerciseName, int sets, int reps) {
            RoutineFinal routine = new RoutineFinal();
            routine.setDay(day);
            routine.setExerciseName(exerciseName);
            routine.setSets(sets);
            routine.setReps(reps);
            em.persist(routine);
        }
    }
}
