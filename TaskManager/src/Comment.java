import java.util.Date;

public class Comment {
    public int ID;
    public String Content;
    public String Author;
    public Date CreatedAt;
    public Comment(int id, String content, String Author, Date CreatedAt)
    {
        this.ID = id;
        this.Content = content;
        this.Author = Author;
        this.CreatedAt = CreatedAt;
    }
}
