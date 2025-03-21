import java.util.Date;
public class Comment implements Cloneable {
    private String id;
    private String content;
    private String author;
    private Date createdAt;

    public Comment(String id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdAt = new Date();
    }

    @Override
    public Comment clone() {
        try {
            Comment cloned = (Comment) super.clone();
            cloned.createdAt = new Date(this.createdAt.getTime());
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public String getContent(){
        return this.content;

    }
    public String getAuthor()
    {
        return this.content;
    }

    public String getId()
    {
        return this.id;
    }

    public Date getcreatedAt()
    {
        return this.createdAt;
    }

    public void setContent(String content)
    {
        this.content=content;
    }

    public void setAuthor()
    {
        this.author=author;
    }
    public void setId(String id)
    {
        this.id=id;
    }
}