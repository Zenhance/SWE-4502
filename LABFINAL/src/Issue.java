import java.util.ArrayList;
import java.util.List;

public class Issue implements Prototype {
    private int id;
    private String title;
    private String description;
    private String priority;
    private String status;
    private String assignedTo;
    private List<String> tags;
    private List<Comment> comments;

    public Issue(int id, String title, String description, String priority, String status, String assignedTo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.assignedTo = assignedTo;
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    @Override
    public Prototype copy() {
        Issue copied = new Issue(this.id, this.title, this.description, this.priority, this.status, this.assignedTo);
        copied.tags = new ArrayList<>(this.tags);
        copied.comments = new ArrayList<>(this.comments);
        return copied;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }
    public void addComment(Comment comment){
        comments.add(comment);

     }


}



