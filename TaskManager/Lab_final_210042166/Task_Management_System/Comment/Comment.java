package Lab_final_210042166.Task_Management_System.Comment;

import java.time.LocalDateTime;
import java.util.Date;

public class Comment {
    private String id;
    private String content;
    private String author;
    private LocalDateTime createdAt;


    public Comment(String id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }

    public String getContent(){
        return content;
    }
    public String getAuthor()
    {
        return author;
    }
    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

}

