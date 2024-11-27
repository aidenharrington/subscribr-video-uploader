package com.project.subscribrVideoUploader;

import com.project.subscribrVideoUploader.orchestrators.VideoUploadOrchestrator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public VideoUploadOrchestrator videoUploadOrchestrator() {
        return new VideoUploadOrchestrator();
    }
}
