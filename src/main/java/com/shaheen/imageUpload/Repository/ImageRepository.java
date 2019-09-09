package com.shaheen.imageUpload.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaheen.imageUpload.Model.Image;
import com.shaheen.imageUpload.Model.User;

public interface ImageRepository extends JpaRepository<Image, Long>{
	public List<Image> findByUser(User user);
}
