package com.project.subscribrVideoUploader.orchestrators;

import com.project.subscribrVideoUploader.models.Video;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VideoUploadOrchestrator {
    private final String SUBSCRIBR_API_URL = "//localhost:8080/";

    // Subscribr URL: /{userId}/videos/{videoId}
    private final String UPLOAD_VIDEO_URL = "/%s/videos/%s";

    // Simulate time to upload video and alert API via webhook when complete
    @Async
    public void uploadVideoMock(Video video) throws InterruptedException {
        // Mock upload video
        Thread.sleep(15000);
        sendVideoUploadCompleteWebhook(video);
    }

    private void sendVideoUploadCompleteWebhook(Video video) {
        String uploadVideoUrl = String.format(UPLOAD_VIDEO_URL, video.getUploaderUserId(), video.getId());
        String url = SUBSCRIBR_API_URL + uploadVideoUrl;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        System.out.println("COMPLETED: " + result);
    }




}
