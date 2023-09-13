package inu890.HealthLounge.domain.analysis;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="guide_video")
public class GuideVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guide_video_id")
    private Long guideVideoId;

    @Column(name = "guide_video_path", nullable = false)
    private String guideVideoPath;

    @Enumerated(EnumType.STRING)
    private ExerciseType exerciseType;

}
