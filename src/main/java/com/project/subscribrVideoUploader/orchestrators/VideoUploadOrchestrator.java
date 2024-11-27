package com.project.subscribrVideoUploader.orchestrators;

import com.project.subscribrVideoUploader.models.Video;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VideoUploadOrchestrator {

    @Value("${subscribrApi.url}")
    private String SUBSCRIBR_API_URL;

    private final String UPLOAD_VIDEO_URL = "/webhooks/%s/videos/%s";

    private final int TIME_TO_SLEEP_IN_MS = 5000;

    // Simulate time to upload video and alert API via webhook when complete
    @Async
    public void uploadVideoMock(Video video) throws InterruptedException {
        System.out.println("Started uploading video: " + video.getName());
        // Mock upload video
        Thread.sleep(TIME_TO_SLEEP_IN_MS);
        System.out.println("Completed uploading video: " + video.getName());
        sendVideoUploadCompleteWebhook(video);
    }

    private void sendVideoUploadCompleteWebhook(Video video) {
        System.out.println("Sending video upload complete webhooks");
        String uploadVideoUrl = String.format(UPLOAD_VIDEO_URL, video.getVideoUploaderId(), video.getId());
        String url = SUBSCRIBR_API_URL + uploadVideoUrl;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(url,video, String.class);

        System.out.println("Webhook arrived with result: " + result);
    }




}
