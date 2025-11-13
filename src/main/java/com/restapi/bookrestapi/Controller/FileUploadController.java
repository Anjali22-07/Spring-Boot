package com.restapi.bookrestapi.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restapi.bookrestapi.dao.BookRepository;
import com.restapi.bookrestapi.helper.FileUploadHelper;

@RestController
public class FileUploadController {

  private final BookRepository bookRepository;

    @Autowired
    private FileUploadHelper fileHelper;

    FileUploadController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){

       try {
         if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No file attached");
            
        }

        // if(!file.getContentType().equals("image/jpeg")){
        //    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Only JPEG file allowed");             
        // }

        //file upload...
       boolean f= fileHelper.uploadFile(file);
           if(f){
         //   return ResponseEntity.ok("File Uploaded successfully");

         //you can also return the path where image has been uploaded
         return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
           }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some Error Occured");

           }

        
       } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
       }

      return ResponseEntity.ok("Working");
    }


}
