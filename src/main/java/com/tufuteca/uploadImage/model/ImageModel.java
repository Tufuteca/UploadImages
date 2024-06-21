package com.tufuteca.uploadImage.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ImageModel {
    private String imageData;
    private Long id;
    private String userlogin;
    private String dateTime;

}
