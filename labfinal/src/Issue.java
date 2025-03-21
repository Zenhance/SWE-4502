import java.lang.reflect.Array;
import java.time.LocalDateTime;

public class Issue{

  private String id;
  private String title;
  private String description;
  private PriorityType priority;
  private StatusType status;
  private LocalDateTime creationDate;
  private LocalDateTime lastModifiedDate;
  private Array[] tags;
  private Comment comments;


  public void addIssue(String id, String title, String description, PriorityType priority, StatusType status, LocalDateTime creationDate, LocalDateTime lastModifiedDate , Array[] tags, Comment comment, Command command){
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

  public String getDescription(){
    return description;
  }

  public PriorityType getPriority(){
    return priority;
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

  public Comment getComments(){
    return comments;
  }
  public void addComment(Comment comment) {

  }

}
