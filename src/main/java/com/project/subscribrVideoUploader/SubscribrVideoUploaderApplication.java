package com.project.subscribrVideoUploader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SubscribrVideoUploaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscribrVideoUploaderApplication.class, args);
	}

}
