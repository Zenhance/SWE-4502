import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Issue implements Cloneable {

    private String id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private Date creationDate;
    private Date lastModifiedDate;
    private String assignedTo;
    private List<String> tags;
    private List<Comment> comments;

    public Issue(String id, String title, String description, Priority priority, String assignedTo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = Status.OPEN;
        this.creationDate = new Date();
        this.lastModifiedDate = creationDate;
        this.assignedTo = assignedTo;
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void changeStatus(Status status) {
        this.status = status;
        this.lastModifiedDate = new Date();
    }

    @Override
    public Issue clone() {
        try {
            Issue cloned = (Issue) super.clone();


            cloned.tags = new ArrayList<>(this.tags);

            cloned.comments = new ArrayList<>();
            for (Comment comment : this.comments) {
                cloned.comments.add(comment.clone());
            }


            cloned.creationDate = new Date(this.creationDate.getTime());
            cloned.lastModifiedDate = new Date(this.lastModifiedDate.getTime());

            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public String getId() {
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription()
    {
        return this.description;
    }

    public Priority getPriority()
    {
        return this.priority;
    }

    public Status getStatus()
    {
        return this.status;
    }

    public Date getCreationDate()
    {
        return this.creationDate;
    }

    public void setTitle(String title)
    {
        this.title=title;
    }

    public void setDescription(String description)
    {
        this.description=description;
    }

    public void setPriority(Priority priority)
    {
        this.priority=priority;
    }

    public void setStatus(Status status)
    {
        this.status=status;
    }

    public void setassignedTo(String assignedTo)
    {
        this.assignedTo=assignedTo;
    }
}