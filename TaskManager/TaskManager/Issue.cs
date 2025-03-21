using System;
using System.Collections.Generic;
using TaskManager;



public class Issue : ICloneable
{
    public int Id { get; set; }
    public string Title { get; set; }
    public string Description { get; set; }
    public Priority Priority { get; set; }
    public Status Status { get; set; } = Status.Open;
    public DateTime CreationDate { get; private set; }
    public DateTime LastModifiedDate { get; private set; }
    public string AssignedTo { get; set; }
    public List<string> Tags { get; private set; }
    public List<Comment> Comments { get; private set; }

   
    public Issue(int id, string title, string description, Priority priority, string assignedTo = null)
    {
        Id = id;
        Title = title;
        Description = description;
        Priority = priority;
        Status = Status.Open;
        CreationDate = DateTime.Now;
        LastModifiedDate = DateTime.Now;
        AssignedTo = assignedTo;
        Tags = new List<string>();
        Comments = new List<Comment>();
    }

    
    public void UpdateStatus(Status newStatus)
    {
        Status = newStatus;
        LastModifiedDate = DateTime.Now;
    }


    public void AddComment(int id, string content, string author)
    {
        Comments.Add(new Comment(id, content, author));
    }


    public object Clone()
    {
        return new Issue(this.Id, this.Title, this.Description, this.Priority, this.AssignedTo)
        {
            Status = this.Status,
            CreationDate = this.CreationDate,
            LastModifiedDate = this.LastModifiedDate,
            Tags = new List<string>(this.Tags),
            Comments = new List<Comment>(this.Comments) 
        };
    }

    public Issue() { }
}
