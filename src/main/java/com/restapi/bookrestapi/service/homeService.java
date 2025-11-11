package com.restapi.bookrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.bookrestapi.dao.BookRepository;
import com.restapi.bookrestapi.entity.Book;

@Component
public class homeService {

    @Autowired
  private BookRepository books;

//    private static  List<Book> list= new ArrayList<>();

//     //setting up some data- for testing purpose

//     static{
//         list.add(new Book(123,"Java Basics","XYZ"));
//         list.add(new Book(245,"Introduction to c", "abc"));
//         list.add(new Book(6706,"Think in java", "abc"));
//     }

    public List<Book> getBooks(){
        
        //return list;
        List<Book> list= (List<Book>)this.books.findAll();
        return list;
    }

    public Book addBook(Book b){
        // list.add(b);
        // return b;
        Book result= this.books.save(b);
        return result;
    } 

    public void deleteBook(int bookId){
       
     //   list.removeIf(book-> book.getId()==bookId);
     this.books.deleteById(bookId);
          
    }

    //update the book
    public void updateBook(Book book,int bookid){
        
        // list=list.stream().map(b->{

        //      if(b.getId()==bookid){
        //         b.setName(book.getName());  //Take the name from newBook → put it inside this book (b).”
        //        b.setAuthor(book.getAuthor());  //“Take the author from newBook → replace the old author.”
        //      }
        //      return b;
        // }).collect(Collectors.toList());
        book.setId(bookid);
        this.books.save(book);

        
    }


}
