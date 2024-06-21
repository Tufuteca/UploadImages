package com.tufuteca.uploadImage.repository;

import com.tufuteca.uploadImage.model.Images;
import com.tufuteca.uploadImage.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagesRepository extends JpaRepository<Images, Long> {
    List<Images> findByUsers(Users user);

    Images findImagesById(Long id);

    Page<Images> findAll(Pageable pageable);
}

