package inu890.HealthLounge.domain.analysis;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="exercise_video")
public class ExerciseVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    private Long videoId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "video_path", nullable = false)
    private String videoPath;

    @Column(name = "video_name",nullable = false)
    private String videoName;

    @Enumerated(EnumType.STRING)
    private ExerciseType exerciseType;


}
