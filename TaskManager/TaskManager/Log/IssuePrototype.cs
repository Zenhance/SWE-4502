﻿//Issue Prototype
using System.Data;
using System.Runtime.InteropServices.JavaScript;
using TaskManager.Model;
using TaskManager.ENUM;
namespace TaskManager.Log;

public class IssuePrototype
{
    public int id;
    public string title;
    public string description;
    public PRIORITY priority;
    public STATUS status;
    public DateTime createdDate;
    public DateTime lastModifiedDate;
    public User AssignedTo;
    
    public List<Comment> comments;
    public List<Tag> tags;

    public IssuePrototype(string title, string description, PRIORITY priority, STATUS status, DateTime createdDate,
        DateTime lastModifiedDate, User AssignedTo)
    {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.AssignedTo = AssignedTo;
    }
}