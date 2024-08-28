package com.scm.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageSevice {

    String uploadImage(MultipartFile contactImage);

}
