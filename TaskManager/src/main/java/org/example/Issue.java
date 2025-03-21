package org.example;

import java.util.List;

public class Issue {
    public int id;
    public String title;
    public String decsription;
    public enum status{
        Open,
        InProgress,
        UnderReview,
        Resolved,
        Closed;
    }
    public enum priority{
        Low,
        Medium,
        High,
        Critical;
    }
    public String creationDate;
    public String lastModifiedDate;
    public String assignedTo;
    public String tags;
    public String comments;



    public void createIssue() {
        System.out.println("Issue created");
    }
    public void updateIssue() {
        System.out.println("Issue updated");
    }
    public void changeIssueStatus(){
        status cng = status.Resolved;
        System.out.println("Issue status changed");
    }
    public void addComment(){
        System.out.println("Comment added");
    }
    public void undoRedo(){
        System.out.println("handling undo-redo of comments");
    }
}
