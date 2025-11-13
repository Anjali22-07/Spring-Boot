package com.restapi.bookrestapi.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

 //   private final String upload_drx="path to your image folder";

    
     private final String uploadDir = System.getProperty("user.dir") + "/uploads/";

    public FileUploadHelper() {
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }


    public boolean uploadFile(MultipartFile multipartfile){
        boolean f=false;

        try {

            InputStream is=multipartfile.getInputStream();
            byte data[]= new byte[is.available()];
            is.read(data);

            FileOutputStream fos=new FileOutputStream(uploadDir+"\\"+multipartfile.getOriginalFilename());
            fos.write(data);

            fos.flush();
            fos.close();
            f=true;

        } catch (Exception e) { 

            e.printStackTrace();
        }
        return f;
    }

}
