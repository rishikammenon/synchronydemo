package com.example.synchronydemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class ImgurImageData {

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("id")
    public String id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("images")
    public ArrayList<ImgurImage> images;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImages(ArrayList<ImgurImage> images) {
        this.images = images;
    }
}
