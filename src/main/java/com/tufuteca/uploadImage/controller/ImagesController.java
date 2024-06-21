package com.tufuteca.uploadImage.controller;

import com.tufuteca.uploadImage.model.Images;
import com.tufuteca.uploadImage.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImagesController {

    @Autowired
    private ImagesService imagesService;

    @PostMapping("/upload")
    public Images uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        byte[] imageData = file.getBytes();
        return imagesService.saveImage(imageData);
    }

    @GetMapping("/{id}")
    public Images getImage(@PathVariable Long id) {
        return imagesService.getImage(id);
    }
}