import java.util.Date;

public class Comment {
    private String id;
    private String comment;
    private String content;
    private String author;
    private Date createdAt;


    public Comment(String id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdAt = new Date(); // Automatically set the creation time
    }



    public String getId()
    {
        return id;
    }
    public String getContent()
    {
        return content;
    }
    public String getAuthor()
    {
        return author;
    }
    public Date getCreatedAt()
    {
        return createdAt;
    }
}