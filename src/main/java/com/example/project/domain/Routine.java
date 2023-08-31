package com.example.project.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Routine {

    @Id @GeneratedValue
    private Long id;

    private DayCount daycount;

    private FitnessLevel level;
    @Column(columnDefinition = "TEXT")
    private String exerciseData; // JSON 형태로 저장되는 운동 데이터

    // 직렬화: ExerciseDetail 리스트를 JSON 문자열로 변환
    public void setExerciseData(List<ExerciseDetail> exercises) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.exerciseData = objectMapper.writeValueAsString(exercises);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            // 적절한 예외 처리 추가
        }
    }

    // 역직렬화: JSON 문자열을 ExerciseDetail 리스트로 변환
    public List<ExerciseDetail> getExerciseData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(this.exerciseData, new TypeReference<List<ExerciseDetail>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            // 적절한 예외 처리 추가
            return Collections.emptyList();
        }
    }

}
