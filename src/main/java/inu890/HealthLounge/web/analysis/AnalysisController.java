package inu890.HealthLounge.web.analysis;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.ObjectMetadata;
import inu890.HealthLounge.domain.analysis.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AnalysisController {

    private final AnalysisRepository analysisRepository;
    private final GuideRepository guideRepository;
    private final AnalysisService analysisService;
    private final AmazonS3Client amazonS3Client;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;


    @GetMapping("/analysis")
    public String analysisForm() {
        return "analysis/analysis";
    }

    @PostMapping("/analysis")
    public String analysis(@RequestParam("file") MultipartFile file, Model model, RedirectAttributes redirectAttributes) {

        try {
            String videoPath = uploadToS3(file);
            ExerciseVideo savedVideo = saveToDb(file.getOriginalFilename(), videoPath);
            String analysisResult = analysisService.analyzeVideo(videoPath);
            Optional<GuideVideo> guideVideo = guideRepository.findByExerciseType(ExerciseType.SQUAT);

            if (guideVideo.isPresent()) {
                model.addAttribute("guideVideoUrl", guideVideo.get().getGuideVideoPath());
            } else {
                model.addAttribute("guideVideoUrl", "");
            }

            model.addAttribute("originalVideoUrl", videoPath);
            model.addAttribute("advice", analysisResult);

            return "analysis/analysis";
        } catch (Exception e) {
            String errorMessage;
            if (e instanceof AmazonS3Exception) {
                errorMessage = "동영상을 저장하는데 실패하였습니다. 잠시 후 다시 시도해주세요.";
            } else if (e instanceof DataAccessException) {
                errorMessage = "동영상을 저장하는데 실패하였습니다. 잠시 후 다시 시도해주세요.";
            } else {
                log.info("error={}", e);
                errorMessage = "에러가 발생하였습니다. 잠시 후 다시 시도해주세요.";
            }

            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/analysis";
        }
    }

    public String uploadToS3(MultipartFile file) throws IOException {
        String key = "videos/" + file.getOriginalFilename();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        amazonS3Client.putObject(bucketName, key, file.getInputStream(), metadata);

        return "https://" + bucketName + ".s3.ap-northeast-2.amazonaws.com/" + key;
    }

    public ExerciseVideo saveToDb(String videoName, String videoPath) {
        ExerciseVideo video = new ExerciseVideo();
        video.setVideoName(videoName);
        video.setVideoPath(videoPath);

        return analysisRepository.save(video);
    }
}
