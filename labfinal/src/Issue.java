import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Issue{

  private String id;
  private String title;
  private String description;
  private PriorityType priority;
  private StatusType status;
  private LocalDateTime creationDate;
  private LocalDateTime lastModifiedDate;
  private Array[] tags;
  private List<Comment> comments;

  public Issue()
  {
    this.id = UUID.randomUUID().toString();
    this.status = StatusType.OPEN;
    this.creationDate = LocalDateTime.now();
    this.lastModifiedDate = LocalDateTime.now();
    this.tags = new Array[]{};
    this.comments = new ArrayList<>();

  }

  public Issue(String id, String title, String description, PriorityType priority, StatusType status, LocalDateTime creationDate, LocalDateTime lastModifiedDate , Array[] tags, List<Comment> comment, Command command){
    this.id = id;
    this.title = title;
    this.description = description;
    this.priority= priority;
    this.status = status;
    this.creationDate=creationDate;
    this.lastModifiedDate=lastModifiedDate;
    this.tags=tags;
    this.comments=comment;

  }

  public String getId(){
    return id;
  }

  public String getTitle(){
    return title;
  }

  public void setTitle(String title){
    this.title = title;
  }

  public String getDescription(){
    return description;
  }

  public void setDescription(String description){
    this.description = description;
  }


  public void getPriority(){
    System.out.println(priority);
  }

  public void setPriority(PriorityType priority){
    this.priority =  priority;
  }

  public LocalDateTime getCreationDate(){
    return creationDate;
  }

  public LocalDateTime getLastModifiedDate(){
    return lastModifiedDate;
  }

  public StatusType getStatus(){
    return status;
  }

  public void setStatus(StatusType status) {
    this.status = status;
    this.lastModifiedDate = LocalDateTime.now();
  }

  public Array[] getTags(){
    return tags;
  }

  public List<Comment> getComments(){
    return comments;
  }
  public void addComment(Comment comment) {

    comments.add(comment);
  }

}
