//package com.example.project.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class AnalysisService {
//
//    private final WebClient webClient;
//
//    @Autowired
//    public AnalysisService(WebClient.Builder webClientBuilder) {
//        this.webClient = webClientBuilder.baseUrl("http://localhost:5000").build();
//    }
//
//    public String analyzeVideo(String videoPath) {
//
//        Map<String, String> requestData = new HashMap<>();
//        requestData.put("videoPath", videoPath);
//
//        return webClient.post()
//                .uri("/analysis")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(requestData))
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//    }
//}