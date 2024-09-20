package com.project.subscribrVideoUploader.models;

import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;

@Getter
@Setter
public class Video {

    private Long id;

    private String name;

    private Timestamp releaseDate;

    private Long uploaderUserId;
}
