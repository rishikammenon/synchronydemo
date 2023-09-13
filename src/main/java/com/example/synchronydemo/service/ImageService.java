package com.example.synchronydemo.service;

import com.example.synchronydemo.model.ImgurGallery;
import com.example.synchronydemo.model.ImgurImage;
import com.example.synchronydemo.model.ImgurImageData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ImageService {
    private static final String IMGUR_CLIENT_ID = "to be configured";

    private static final String IMGUR_GALLERY_URI = "https://api.imgur.com/3/gallery/hot/viral/0.json";


    public ImgurImage getImage(String id) {
       log.info("getImage called for id {}", id);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Client-ID " + IMGUR_CLIENT_ID);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<ImgurGallery> response = restTemplate.exchange(IMGUR_GALLERY_URI, HttpMethod.GET, entity, ImgurGallery.class);

        List<ImgurImageData> datas = response.getBody().getData().stream().filter(data -> !(data.getImages() == null))
                .collect(Collectors.toList());
        Optional<ImgurImageData> responseImage = datas.stream()
                .filter(inner -> inner.getImages().stream().anyMatch(image -> id.equals(image.id))).findFirst();
        if(responseImage.isPresent())
            return responseImage.get().getImages().get(0);
        else
            return null;
    }
}

