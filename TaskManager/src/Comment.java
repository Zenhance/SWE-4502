import java.util.Date;

class Comment {
    private final String id, content, author;
    private final Date createdAt;

    public Comment(String id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdAt = new Date();
    }
} 