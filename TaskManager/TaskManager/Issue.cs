using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    public class Issue : IClonable
    {
        public int Id { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public Priority Priority { get; set; }
        public Status Status { get; set; }
        public DateTime CreationDate { get; set; }
        public DateTime LastModifiedDate { get; set; }
        public string AssignedTo { get; set; }
        public String Tags { get; set; }
        public List<Comment> Comments = new List<Comment>();
        ICommand command;


        public Issue(int Id, string Title, string Description, Priority Priority, Status Status, DateTime CreationDate, DateTime LastModifiedDate, string AssignedTo, string Tags, List<Comment> Comments)
        {
            this.Id = Id;
            this.Title = Title;
            this.Description = Description;
            this.Priority = Priority;
            this.Status = Status;
            this.CreationDate = CreationDate;
            this.LastModifiedDate = LastModifiedDate;
            this.AssignedTo = AssignedTo;
            this.Tags = Tags;
            this.Comments = Comments;
        }


        
        public IClonable Clone()
        {
            return new Issue
            (
                Id = this.Id,
                Title = this.Title,
                Description = this.Description,
                Priority = this.Priority,
                Status = this.Status,
                CreationDate = this.CreationDate,
                LastModifiedDate = this.LastModifiedDate,
                AssignedTo = this.AssignedTo,
                Tags = this.Tags,
                Comments = this.Comments
            );
        }

        public void ExecuteCommand(ICommand command)
        {
            command.Execute();
        }
    }
}
