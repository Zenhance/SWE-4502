package labFinal_164.model;

import java.time.LocalDateTime;

public class Comment {
    private String id;
    private String content;
    private String Author;
    private LocalDateTime createdAt;

    public Comment() {
        this.id = id;
        this.content = content;
        this.Author = Author;
        this.createdAt = LocalDateTime.now();

    }


}
