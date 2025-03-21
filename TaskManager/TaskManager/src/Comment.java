import java.util.Date;
public class Comment{
    public int Id;
    public String Content;
    public String Author;
    public Date CreatedAt;

    public Comment(int Id,String Content){
        this.Id=Id;
        this.Content=Content;
    }
}