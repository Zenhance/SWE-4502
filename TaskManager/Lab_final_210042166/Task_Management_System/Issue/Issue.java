package Lab_final_210042166.Task_Management_System.Issue;
import Lab_final_210042166.Task_Management_System.Comment.Comment;
import Lab_final_210042166.Task_Management_System.Enum.Priority;
import Lab_final_210042166.Task_Management_System.Enum.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class Issue {
    private static int idCounter=1;
    private int id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private LocalDateTime creationDate;
    private LocalDateTime lastModifiedDate;
    private String assignedTo;
    private List<String> tags;
    private List<Comment> comments;


    public Issue(String title,String description,Priority priority,String assignedTo)
    {
        this.id=idCounter++;
        this.title=title;
        this.description=description;
        this.priority=priority;
        this.status=Status.OPEN;
        this.creationDate=LocalDateTime.now();
        this.lastModifiedDate=LocalDateTime.now();
        this.tags=new ArrayList<>();
        this.comments=new ArrayList<>();
        this.assignedTo=assignedTo;
    }
    public void addComment(Comment comment)
    {
        this.comments.add(comment);
        this.lastModifiedDate=LocalDateTime.now();
    }
    public void changeStatus(Status newStatus)
    {
        this.status=newStatus;
        this.lastModifiedDate=LocalDateTime.now();
    }
    public int getId(){
        return id;
    }
    public Status getStatus(){
        return status;
    }
    public void setTitle(String title){
     this.title=title;
     this.lastModifiedDate=LocalDateTime.now();

    }
    public String getAssignedTo()
    {
        return assignedTo;
    }
    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
        this.lastModifiedDate=LocalDateTime.now();
    }




}
