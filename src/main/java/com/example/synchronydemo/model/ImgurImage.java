package com.example.synchronydemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ImgurImage implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("id")
    public String id;
    @JsonProperty("link")
    public String link;
    @JsonProperty("mp4")
    public String mp4;
    @JsonProperty("gifv")
    public String gifv;
}
