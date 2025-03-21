using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    public class Issue
    {
        public int Id;
        public string Title;
        public string Description;
        public Priority priority;
        public Status status;
        public DateTime CreationDate;
        public DateTime LastModifiedDate;
        public User AssignedTo;

        public List<string> Tags;
        public List<Comments> comments;


        public Issue(int Id, string Title, string Description, Priority priority, Status status, DateTime CreationDate, DateTime LastModifiedDate, User AssignedTo)
        {
            this.Id = Id;
            this.Title = Title;
            this.Description = Description;
            this.priority = priority;
            this.status = status;
            this.CreationDate = CreationDate;
            this.LastModifiedDate = LastModifiedDate;
            this.AssignedTo = AssignedTo;
        }

    }
}
