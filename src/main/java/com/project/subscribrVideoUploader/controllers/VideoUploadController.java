package com.project.subscribrVideoUploader.controllers;

import com.project.subscribrVideoUploader.models.Video;
import com.project.subscribrVideoUploader.orchestrators.VideoUploadOrchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@CrossOrigin(origins = "*")
@RequestMapping("/videos")
public class VideoUploadController {

    @Autowired
    ApplicationContext applicationContext;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadVideo(@RequestBody Video newVideo) {
        // Start async upload - this will generate webhook
        try {
            VideoUploadOrchestrator videoUploadOrchestrator = applicationContext.getBean(VideoUploadOrchestrator.class);
            videoUploadOrchestrator.uploadVideoMock(newVideo);
        } catch (InterruptedException e) {
            // Ignored exception since this is async endpoint & WH operation
            // This exception would be logged only
            System.out.println("Received async exception: " + e.getMessage());
        }

        return ResponseEntity.ok("Success");


    }
}
