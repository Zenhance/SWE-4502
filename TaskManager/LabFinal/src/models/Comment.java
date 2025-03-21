package models;

import java.util.Date;
import java.util.UUID;

public class Comment {
    String Id;
    String Author;
    String content;
    Date CreatedAt;

    public Comment(String Author, String content){

        Id = String.valueOf(UUID.randomUUID());
        this.Author = Author;
        this.content = content;
        CreatedAt = new Date();
    }

    public String getId() {
        return Id;
    }
}
