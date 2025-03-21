package org.example;

import java.util.Date;

public class Comment {
    public int id;
    public String content;
    public String author;
    public Date createdAt;

    public Comment(String content, String author){
        this.id= id;
        this.content= content;
        this.author= author;
        this.createdAt= createdAt;
    }

    public int getCommentId(){
        return id;
    }
    public String getContent(){
        return content;
    }
    public String getAuthor(){
        return author;
    }
    public Date getCreatedAt(){
        return createdAt;
    }
}
