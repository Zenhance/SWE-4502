package main.java.com.taskmanager.model;

import java.util.Date;
public class Comment {

    private String id;
    private String content;
    private String author;
    private Date createdAt;

    public Comment(String id,String content,String author,Date createdAt ) {
        this.id=id;
        this.content=content;
        this.author=author;
        this.createdAt=createdAt;
    }
}
