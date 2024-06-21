package com.tufuteca.uploadImage.service;

import com.tufuteca.uploadImage.model.Images;
import com.tufuteca.uploadImage.model.Users;
import com.tufuteca.uploadImage.repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<Images> getAllImagesSortByDate() {
        return imagesRepository.findAll(Sort.by(Sort.Direction.DESC, "dateImageAdded"));
    }
    public Page<Images> getAllImagesPagedAndSorted(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "dateImageAdded"));
        return imagesRepository.findAll(pageable);
    }

    public void delete(Images images) {
        imagesRepository.delete(images);
    }

    public Images findImageById(Long id) {
        return imagesRepository.findImagesById(id);
    }
}