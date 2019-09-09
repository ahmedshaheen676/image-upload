package com.shaheen.imageUpload.controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shaheen.imageUpload.Model.Image;

import com.shaheen.imageUpload.Model.User;
import com.shaheen.imageUpload.Service.Image.ImageService;
import com.shaheen.imageUpload.Resposes.ImageResponse;
import com.shaheen.imageUpload.Resposes.allImages;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<ImageResponse> uploadFile(@Valid @RequestParam("file") MultipartFile file) {
        User u = new User();
        u.setId(1);
        try {
            Image image = new Image(file.getOriginalFilename(), file.getContentType(), file.getBytes(), u);
            image = imageService.save(image);

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
                    .path("" + image.getId()).toUriString();

            return new ResponseEntity(new ImageResponse(image.getName(), fileDownloadUri, file.getContentType(), file.getSize()),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
//    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
//    public ResponseEntity<ImageResponse> uploadFile(@RequestBody ImageResponse imageResponse) {
//                       
//        User u = new User();
//        u.setId(1);
//        
//        try {
//            Image image = new Image(imageResponse.getName(),imageResponse.getType(), , u);
////            image = imageService.save(image);
////
////            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
////                    .path("" + image.getId()).toUriString();
////
////            return new ResponseEntity(new ImageResponse(image.getName(), fileDownloadUri, file.getContentType(), file.getSize()),
////                    HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity("error", HttpStatus.BAD_REQUEST);
//        }
//;
//
//    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<ImageResponse> getAll() {
        Set<ImageResponse> resposes = new HashSet<>();
        List<Image> images = imageService.findAll();
        images.forEach((Image image) -> {
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
                    .path("" + image.getId()).toUriString();
            resposes.add(new ImageResponse(image.getName(), fileDownloadUri,
                    image.getType(),
                    image.getData().length
            ));
        });
       
        return new ResponseEntity(new allImages("images", resposes), HttpStatus.OK);

    }

    @RequestMapping(value = "/{imageId}", method = RequestMethod.GET)
    public ResponseEntity<Resource> getImage(@PathVariable("imageId") long imageId) {
        Image image = imageService.findById(imageId);
        return ResponseEntity.ok()
                .contentType(org.springframework.http.MediaType.parseMediaType(image.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getName() + "\"")
                .body(new ByteArrayResource(image.getData()));

    }

    @RequestMapping(value = "/{imageId}", method = RequestMethod.DELETE)
    public ResponseEntity<Resource> deleteImage(@PathVariable("imageId") long imageId) {
        Image image = imageService.findById(imageId);
        if (image != null) {
            imageService.delete(image);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    
}
