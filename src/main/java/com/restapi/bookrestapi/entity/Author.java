package com.restapi.bookrestapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private int author_id;
     private String fName;
     private String lName;
     private String language;
     @OneToOne(mappedBy = "author")
     @JsonBackReference
     private Book book;

     public int getAuthor_id() {
         return author_id;
     }
     public void setAuthor_id(int author_id) {
         this.author_id = author_id;
     }
     public String getfName() {
         return fName;
     }
     public void setfName(String fName) {
         this.fName = fName;
     }
     public String getlName() {
         return lName;
     }
     public void setlName(String lName) {
         this.lName = lName;
     }
     public String getLanguage() {
         return language;
     }
     public void setLanguage(String language) {
         this.language = language;
     }
     public Book getBook() {
         return book;
     }
     public void setBook(Book book) {
         this.book = book;
     }
     @Override
    public String toString() {
        return "Author [author_id=" + author_id + ", fName=" + fName + ", lName=" + lName + ", language=" + language
                + ", book=" + book + "]";
    }
     public Author() {
     }
     public Author(int author_id, String fName, String lName, String language, Book book) {
        this.author_id = author_id;
        this.fName = fName;
        this.lName = lName;
        this.language = language;
        this.book = book;
     }
    
     

     
     
    
     

}
