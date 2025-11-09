package com.restapi.bookrestapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Book> getBooks(){
      
        return this.hs.getBooks();
 
    }
    
    //to create data on server we use POST Method

    @PostMapping("/books")
    public Book addBooks(@RequestBody Book book){
       
      Book b=this.hs.addBook(book);
      return b;
        

    }
    
}
