package Lab_final_210042166.Task_Management_System.Comment;

import java.time.LocalDateTime;

public class Comment {
    private static int idCounter=1;
    private int id;
    private String content;
    private String author;
    private LocalDateTime createdAt;

    public Comment(String content,String author)
    {
        this.id=idCounter++;
        this.content=content;
        this.author=author;
        this.createdAt=LocalDateTime.now();
    }
    public String getContent(){
        return content;
    }
    public String getAuthor()
    {
        return author;
    }
}

