/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen.imageUpload.Resposes;

import java.util.Set;

/**
 *
 * @author lts
 */
public class allImages {

    private String images;
    private Set<ImageResponse> imageResponses;

    public allImages() {
    }

    public allImages(String images, Set<ImageResponse> imageResponses) {
        this.images = images;
        this.imageResponses = imageResponses;
    }

    /**
     * @return the images
     */
    public String getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     * @return the imageResponses
     */
    public Set<ImageResponse> getImageResponses() {
        return imageResponses;
    }

    /**
     * @param imageResponses the imageResponses to set
     */
    public void setImageResponses(Set<ImageResponse> imageResponses) {
        this.imageResponses = imageResponses;
    }

}
