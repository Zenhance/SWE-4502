package models;

import java.util.Date;

public class Comment {
    String Id;
    String Author;
    String content;
    Date CreatedAt;

    public Comment(String id, String Author, String content){
        this.Id = id;
        this.Author = Author;
        this.content = content;
        CreatedAt = new Date();
    }

    public String getId() {
        return Id;
    }
}
