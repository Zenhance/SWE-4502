package Class;

import java.sql.Date;

public class Comment {
    private int id;
    private String content;

    private String Author;

    private String createdAt;

    public Comment(int id, String content, String author, String createdAt){
        this.id=id;
        this.Author=author;
        this.content=content;
        this.createdAt=createdAt;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return Author;
    }
}
