import java.sql.Date;

public class Comment {
    private int id;
    private String content;

    private String Author;

    private Date createdAt;

    public Comment(int id, String content, String author, Date createdAt){
        this.id=id;
        this.Author=author;
        this.content=content;
        this.createdAt=createdAt;
    }
}
