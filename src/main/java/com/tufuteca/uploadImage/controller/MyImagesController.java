package com.tufuteca.uploadImage.controller;

import com.tufuteca.uploadImage.model.ImageModel;
import com.tufuteca.uploadImage.model.Images;
import com.tufuteca.uploadImage.model.Users;
import com.tufuteca.uploadImage.service.ImagesService;
import com.tufuteca.uploadImage.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/my-images")
public class MyImagesController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private ImagesService imagesService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String myImagesPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = usersService.findByLogin(authentication.getName());
        List<Images> userPhotos = imagesService.findByUser(user);

        List<ImageModel> imageModels = userPhotos.stream()
                .map(image -> new ImageModel(Base64.getEncoder().encodeToString(image.getImageData()), image.getId()))
                .collect(Collectors.toList());

        model.addAttribute("userPhotos", imageModels);
        return "my-images";
    }



    @PostMapping("/upload")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = usersService.findByLogin(authentication.getName());

        try {
            Images image = new Images();
            image.setUsers(user);
            image.setImageData(imageFile.getBytes());
            image.setDateImageAdded(LocalDateTime.now());
            imagesService.save(image);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/my-images";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String deleteImage(@PathVariable Long id) {
        System.out.println(id);
        imagesService.deleteById(id);
        return "redirect:/my-images";
    }

}
