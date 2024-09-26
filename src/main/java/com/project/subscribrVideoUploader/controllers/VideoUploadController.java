package com.project.subscribrVideoUploader.controllers;

import com.project.subscribrVideoUploader.models.Video;
import com.project.subscribrVideoUploader.orchestrators.VideoUploadOrchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/videos")
public class VideoUploadController {
    private final VideoUploadOrchestrator videoUploadOrchestrator;

    @Autowired
    public VideoUploadController(VideoUploadOrchestrator videoUploadOrchestrator) {
        this.videoUploadOrchestrator = videoUploadOrchestrator;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadVideo(@RequestBody Video newVideo) {
        // Start async upload - this will generate webhook
        System.out.println("Hit");
        try {
            videoUploadOrchestrator.uploadVideoMock(newVideo);
        } catch (InterruptedException e) {
            // Ignored exception since this is async endpoint & WH operation
            // This exception would be logged only
        }

        return ResponseEntity.ok("Success");


    }

    @GetMapping("/upload")
    public ResponseEntity<String> uploadVideo() {
        System.out.println("hit");

        return ResponseEntity.ok("Success");


    }
}
