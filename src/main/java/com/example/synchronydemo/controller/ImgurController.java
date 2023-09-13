package com.example.synchronydemo.controller;

import com.example.synchronydemo.model.ImgurImage;
import com.example.synchronydemo.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/java/app/imgur")
public class ImgurController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/viewImages/{id}")
    public ImgurImage getImage(@PathVariable("id") String id) {
        log.info("getImage called for id {}", id);
        return imageService.getImage(id);
    }
}
