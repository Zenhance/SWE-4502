import java.time.LocalDateTime;

public class Comment {

    public int Id;

    public String Content;

    public String Author;

    public LocalDateTime CreatedAt;


    public Comment (int ID, String Content, String Author, LocalDateTime CreatedAt){

        this.Id=ID;
        this.Content=Content;

        this.Author=Author;

        this.CreatedAt=CreatedAt;

    }










}
