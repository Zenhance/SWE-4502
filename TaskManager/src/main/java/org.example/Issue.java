package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Issue
{


    public String IssueID,Description,Title,Priority;
    public Date CreationDate;
    public Date LastModifiedDate;
    public String Tags[];
    public List<Comment> commentList =new ArrayList<>();
    public Status status;

    public Issue(String issueID, String description, String title, String priority, Date creationDate, Date lastModifiedDate, String[] tags, List<Comment> commentList, Status status) {
        IssueID = issueID;
        Description = description;
        Title = title;
        Priority = priority;
        CreationDate = creationDate;
        LastModifiedDate = lastModifiedDate;
        Tags = tags;
        this.commentList = commentList;
        this.status = status;
    }
}
