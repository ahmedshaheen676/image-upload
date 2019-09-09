package com.shaheen.imageUpload.Service.Image.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaheen.imageUpload.Model.Image;
import com.shaheen.imageUpload.Model.User;
import com.shaheen.imageUpload.Repository.ImageRepository;
import com.shaheen.imageUpload.Service.Image.ImageService;
import com.shaheen.imageUpload.errors.exceptions.ConfilectException;
import com.shaheen.imageUpload.errors.exceptions.NotFoundException;
import java.util.NoSuchElementException;

@Service
public class ImageServiceImpl implements ImageService {
    
    @Autowired
    private ImageRepository imageRepository;
    
    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }
    
    @Override
    public List<Image> findByUser(User user) {
        
        return imageRepository.findByUser(user);
    }
    
    @Override
    public Image findById(long id) {
        try {
            return imageRepository.findById(id).get();
            
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with id [%s] was found in the database", id));
        }
    }
    
    @Override
    public Image save(Image image) {
        try {
            
            return imageRepository.save(image);
        } catch (Exception e) {
            throw new ConfilectException("this image has been saved before");
        }
    }
    
    @Override
    public void delete(Image image) {
        imageRepository.delete(image);
    }
    
}
