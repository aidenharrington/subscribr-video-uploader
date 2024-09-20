package com.project.subscribrVideoUploader.controllers;

import com.project.subscribrVideoUploader.models.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/videos")
public class VideoUploadController {
    private final VideoUploadController videoUploadController;

    @Autowired
    public VideoUploadController(VideoUploadController videoUploadController) {
        this.videoUploadController = videoUploadController;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadVideo(@RequestBody Video newVideo) {
        // Start async upload - this will generate webhook
        videoUploadController.uploadVideo(newVideo);

        return ResponseEntity.ok("Success");


    }
}
