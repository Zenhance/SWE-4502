using System;
using System.Collections.Generic;
using System.Diagnostics.Tracing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dpfinal_200042152
{
    public class TaskManager
    {
        public int Id;
        public string Title;
        public string Description;
        public enum Priority
        {
            Low,
            Medium,
            High,
            Critical
        };

        public enum Status
        {
            Open,
            InProgress,
            UnderReview,
            Resolved,
            Closed

        };

        public DateTime CreationDate;
        public DateTime LastModifiedDate;
        public string AssignedTo;

        List<Tag> Tags;
        List<Comment> Comments;

        public TaskManager(int _id, string _title, string _description, Priority _)





    }
}
