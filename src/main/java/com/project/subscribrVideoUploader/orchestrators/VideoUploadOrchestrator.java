package com.project.subscribrVideoUploader.orchestrators;

import com.project.subscribrVideoUploader.models.Video;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VideoUploadOrchestrator {
    private final String SUBSCRIBR_API_URL = "http://localhost:8080/";

    // Subscribr URL: /{userId}/videos/{videoId}
    private final String UPLOAD_VIDEO_URL = "webhooks/%s/videos/%s";

    private final int TIME_TO_SLEEP_IN_MS = 5000;

    // Simulate time to upload video and alert API via webhook when complete
    @Async
    public void uploadVideoMock(Video video) throws InterruptedException {
        // Mock upload video
        Thread.sleep(TIME_TO_SLEEP_IN_MS);
        sendVideoUploadCompleteWebhook(video);
    }

    private void sendVideoUploadCompleteWebhook(Video video) {
        String uploadVideoUrl = String.format(UPLOAD_VIDEO_URL, video.getVideoUploaderId(), video.getId());
        String url = SUBSCRIBR_API_URL + uploadVideoUrl;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(url,video, String.class);

        System.out.println("COMPLETED: " + result);
    }




}
