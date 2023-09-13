package com.example.synchronydemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class ImgurGallery {

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("data")
    public ArrayList<ImgurImageData> data;

    public ArrayList<ImgurImageData> getData() {
        return data;
    }

    public void setData(ArrayList<ImgurImageData> data) {
        this.data = data;
    }
}
