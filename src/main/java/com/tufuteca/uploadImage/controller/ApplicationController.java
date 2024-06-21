package com.tufuteca.uploadImage.controller;

import com.tufuteca.uploadImage.model.ImageModel;
import com.tufuteca.uploadImage.model.Images;
import com.tufuteca.uploadImage.model.Users;
import com.tufuteca.uploadImage.service.ImagesService;
import com.tufuteca.uploadImage.service.TimeAgoService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ApplicationController {

    @Autowired
    private ImagesService imagesService;
    @Autowired
    private TimeAgoService timeAgoService;

    @GetMapping("/")
    public String getIndexPage(@RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "size", defaultValue = "10") int size,
                               Model model) {
        Page<Images> imagesPage = imagesService.getAllImagesPagedAndSorted(page, size);

        List<ImageModel> imageModels = imagesPage.getContent().stream()
                .map(image -> new ImageModel(Base64.getEncoder().encodeToString(image.getImageData()),
                        image.getId(),
                        image.getUsers().getLogin(),
                        timeAgoService.getTimeAgo(image.getDateImageAdded())))
                .collect(Collectors.toList());

        model.addAttribute("imagesPage", imagesPage);
        model.addAttribute("userPhotos", imageModels);
        return "index";
    }

    @PostMapping("/deleteImage/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteImage(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Images images = imagesService.findImageById(id);
        imagesService.delete(images);
        redirectAttributes.addFlashAttribute("message", "Фотография удалена");
        return "redirect:/";
    }


    @GetMapping("/authorization")
    public String getAuthorizationPage(){
        return "authorization";
    }

    @GetMapping("/register")
    public String getRegistrationPage(){
        return "registration";
    }
}
