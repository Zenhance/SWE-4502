package org.example;

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

    public void createIssue(String createIssue) {

    }
}
