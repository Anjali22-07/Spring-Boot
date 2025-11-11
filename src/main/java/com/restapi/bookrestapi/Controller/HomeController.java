package com.restapi.bookrestapi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.bookrestapi.entity.Book;
import com.restapi.bookrestapi.service.homeService;



@RestController
public class HomeController {
   
    @Autowired
    homeService hs= new homeService();

    @GetMapping("/books")  
    public ResponseEntity<List<Book>> getBooks(){
      
       List<Book> book= hs.getBooks();
      if(book.size()<=0){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        //build()--creates a new object ,with noo data and only status 
      }else 
        return ResponseEntity.of(Optional.of(book)); 
    }
    
    //to create data on server we use POST Method

    @PostMapping("/books")
    public ResponseEntity<Book> addBooks(@RequestBody Book book){
       try{
      Book b=this.hs.addBook(book);
      return ResponseEntity.status(HttpStatus.CREATED).body(b);
       }
       catch(Exception e){
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }  

    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBooks(@PathVariable("id") int id){
      try{
      this.hs.deleteBook(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
      }
     catch(Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }
    }

    
    
}
