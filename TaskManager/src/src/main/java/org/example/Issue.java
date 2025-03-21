package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Issue
{


    public String IssueID,Description,Status,Title,Priority;
    public Date CreationDate;
    public Date LastModifiedDate;
    public String Tags[];
    public List<Comment> commentList =new ArrayList<>();




}
