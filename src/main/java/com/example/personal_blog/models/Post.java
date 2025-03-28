package com.example.personal_blog.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {

    public Post(String author, String title, String full_text){
        this.author = author;
        this.title = title;
        this.full_text = full_text;
        
    }

    public Post(){}
    
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String author, title;
    @Column(length = 65535) 
    private String full_text;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
   
    public String getFull_text(){
        return full_text;
    }
    public void setFull_text(String full_text){
        this.full_text=full_text;
    }
   

}
