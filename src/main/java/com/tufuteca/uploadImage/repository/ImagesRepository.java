package com.tufuteca.uploadImage.repository;

import com.tufuteca.uploadImage.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagesRepository extends JpaRepository<Images, Long> {
}
