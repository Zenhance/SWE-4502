using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace labfinal_210042111
{
    public enum Priority { low, medium, high, critical }
    public enum Status { open, inProgress, underReview, resolved, closed }

    public class Issue
    {
        public int Id { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public Priority priority { get; set; }
        public Status status { get; set; }
        public DateTime CreationDare { get; set; }
        public DateTime LastModificationDate { get; set; }
        public string AssignTo { get; set; }
        public List<string> Tags { get; set; } = new List<string>();
        public List<Comment> Comments { get; set; } = new List<Comment>();

        public Stack<string> titles;

        public Stack<string> descriptions;


        public Issue(int id, string title, string description, Priority priority, string assignedTo)
        {
            Id = id;
            Title = title;
            Description = description;
            this.priority= priority;
            AssignTo = assignedTo;

        }

        public List<Comment> GetComment()
        {
            return Comments;

        }
        public Status getStatus()
        {
            return status;
        }
        public int GetId()
        {
            return Id;
        }

        public string getTitle()
        {
            return Title;
        }
        public string getDescription()
        {
            return Description;
        }

        public void setTitle(string title)
        {
            Title = title;
            titles.Push(Title);
        }

        public void undoTitle(string title)
        {
            foreach (var item in titles)
                if(item==title)
            Title = titles.Peek();
            titles.Pop();
        }
        public void undoDescription(string des)
        {
            foreach (var item in descriptions)
                if(item==des) 
                    descriptions.Peek();
                    descriptions.Pop();

              
        }
        public void setDescription(string description)
        {
            Description = description;
            descriptions.Push(description);
        }
        public void AddTag(string tag)
        {
            Tags.Add(tag);
        }
        public void AddComments(Comment comments)
        {
            Comments.Add(comments);
        }

        public void changeStatus(Status status)
        {
            this.status = status;
            LastModificationDate= DateTime.Now;
        }

    }
}
