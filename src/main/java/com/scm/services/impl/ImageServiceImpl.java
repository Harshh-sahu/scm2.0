package com.scm.services.impl;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.scm.services.ImageSevice;

@Service
public class ImageServiceImpl implements ImageSevice {

    private Cloudinary cloudinary
;
    public ImageServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }
    @Override
    public String uploadImage(MultipartFile contactImage) {
     
        String filename = UUID.randomUUID().toString();
        // Implement image uploading logic here
try {
    byte[] data = new byte[contactImage.getInputStream().available()];
    contactImage.getInputStream().read(data);
    cloudinary.uploader().upload(data, ObjectUtils.asMap("public_id",filename));
} catch (IOException e) {
    e.printStackTrace();
}
//and return karega url

return "";




    }



}
