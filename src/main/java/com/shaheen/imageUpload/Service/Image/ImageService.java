package com.shaheen.imageUpload.Service.Image;

import com.shaheen.imageUpload.Model.User;

import java.util.List;

import com.shaheen.imageUpload.Model.Image;

public interface ImageService {

    public List<Image> findAll();

    public List<Image> findByUser(User user);

    public Image findById(long id);

    public Image save(Image image);

    public void delete(Image image);
}
