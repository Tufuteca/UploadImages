package com.tufuteca.uploadImage.service;

import com.tufuteca.uploadImage.model.Images;
import com.tufuteca.uploadImage.repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ImagesService {

    @Autowired
    private ImagesRepository imagesRepository;

    public Images saveImage(byte[] imageData) {
        Images image = new Images();
        image.setDateImageAdded(LocalDateTime.now());
        image.setImageData(imageData);
        return imagesRepository.save(image);
    }

    public Images getImage(Long id) {
        return imagesRepository.findById(id).orElse(null);
    }
}