import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Issue {
    public String id;
    public String title;
    public String description;
    public String priority;
    public String status;
    public Date creationDate;
    public Date lastModifiedDate;
    public String AssignedTo;
    private List<String> tags;
    private List<Comment> comments;

    public Issue(String id, String title, String description, String priority, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.creationDate = new Date();
        this.lastModifiedDate = new Date();
        this.comments = new ArrayList<>();
    }

    public Issue(Issue issue) {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    public List<Comment> getComments() {
        return comments;  // Returns the list of comments
    }

    private List<IObserver> observers = new ArrayList<>();

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (IObserver observer : observers) {
            observer.update(message);
        }
    }

    public void changeStatus(String newStatus) {
        this.status = newStatus;
        notifyObservers(newStatus);
    }

    public String getId() {
        return id;
    }

    public Issue clone() {
        try {
            return (Issue) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getTitle() {
        return title;
    }

}
