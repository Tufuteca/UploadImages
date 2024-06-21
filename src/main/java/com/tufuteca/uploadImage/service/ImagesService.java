package com.tufuteca.uploadImage.service;

import com.tufuteca.uploadImage.model.Images;
import com.tufuteca.uploadImage.model.Users;
import com.tufuteca.uploadImage.repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ImagesService {

    @Autowired
    private ImagesRepository imagesRepository;


    public List<Images> findByUser(Users user) {
        return imagesRepository.findByUsers(user);
    }

    public void save(Images image) {
        imagesRepository.save(image);
    }


    public void deleteById(Long id) {
        imagesRepository.delete(imagesRepository.findImagesById(id));
    }
}