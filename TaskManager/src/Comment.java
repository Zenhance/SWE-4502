import java.util.Date;

class Comment {
    private static int counter = 1;
    private int id;
    private String content;
    private String author;
    private Date createdAt;

    public Comment(String content, String author) {
        this.id = counter++;
        this.content = content;
        this.author = author;
        this.createdAt = new Date();

    }
}
