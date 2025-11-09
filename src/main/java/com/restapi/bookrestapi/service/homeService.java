package com.restapi.bookrestapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restapi.bookrestapi.entity.Book;

@Component
public class homeService {

   private static  List<Book> list= new ArrayList<>();

    //setting up some data- for testing purpose

    static{
        list.add(new Book(123,"Java Basics","XYZ"));
        list.add(new Book(245,"Introduction to c", "abc"));
        list.add(new Book(6706,"Think in java", "abc"));
    }

    public List<Book> getBooks(){
        
        return list;
    }

    public Book addBook(Book b){
        list.add(b);
        return b;
    }


}
