using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Net.Mail;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace TaskManager_112
{
    public class Issue
    {
        public int ID { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public Priority Priority { get; set; }
        public Status Status { get; set; }
        public DateTime CreationDate { get; set; }
        public DateTime LastModifiedDate { get; set; }
        public string AssignedTo { get; set; }
        public List<string> Tags { get; set; } //cause tags can be multiple
        public List<Comment> Comments { get; set; } //cause comments can be multiple
        public Issue(int id, string title, string description, Priority priority)
        {
            ID = id;
            Title = title;
            Description = description;
            Priority = priority;
            CreationDate = DateTime.Now;
            LastModifiedDate = DateTime.Now;
            Tags = new List<string>();
            Comments = new List<Comment>();

        }




    }

    //for my advantage
    public enum Priority 
    {
        Low,
        Medium,
        High,
        Critical
    }
    public enum Status
    {
        Open,
        InProgress,
        UnderReview,
        Resolved,
        Closed
    }
}


