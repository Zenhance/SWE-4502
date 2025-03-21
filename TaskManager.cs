using dpfinal_200042152;
using System;
using System.Collections.Generic;
using System.Diagnostics.Tracing;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Security.Policy;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace dpfinal_200042152
{
    public enum Status
    {
        Open,
        InProgress,
        UnderReview,
        Resolved,
        Closed

    };

    public enum Priority
    {
        Low,
        Medium,
        High,
        Critical
    };

    public class TaskManager : ICloneable
    {
        public int Id { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public Priority Priority { get; set; }

        public Status Status { get; set; }

        public DateTime CreationDate { get; set; }
        public DateTime LastModifiedDate { get; set; }
        public string AssignedTo;

         public List<string> Tags;
         public List<Comment> Comments;

        public TaskManager(int _id, string _title, string _description, Priority _priority, string _assignedTo)
        {
            Id = _id;
            Title = _title;
            Description = _description;
            Priority = _priority;
            AssignedTo = _assignedTo;

            CreationDate = DateTime.UtcNow;
            LastModifiedDate = CreationDate;
            Tags = new List<string>();
            Comments = new List<Comment>();


        }

        public void AddComment(Comment comment)
        {
            Comments.Add(comment);
            LastModifiedDate = DateTime.UtcNow;

        }


        public void ChangeStatus(Status newStatus)
        
        { 
            Status = newStatus;
            LastModifiedDate = DateTime.UtcNow;


        }



        public object Clone()
        {
            TaskManager clone = new TaskManager(Id, Title, Description, Priority, AssignedTo)
            {
                Status = this.Status,
                LastModifiedDate = this.LastModifiedDate,
                CreationDate = this.CreationDate,
                

                Tags = new List<string>(this.Tags),
                Comments = this.Comments.Select(c => new Comment(c)).ToList(),

            };


            return clone;




        }


    }

}
