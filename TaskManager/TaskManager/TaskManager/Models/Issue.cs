using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using global::TaskManager.Enums;
using System;
using System.Collections.Generic;
using TaskManager.Models;

namespace TaskManager.Models
{
    public class Issue
    {
        public Guid Id { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public Priority Priority { get; set; }
        public Status Status { get; set; }
        public DateTime CreationDate { get; set; }
        public DateTime LastModifiedDate { get; set; }
        public string AssignedTo { get; set; }
        public List<string> Tags { get; set; }
        public List<Comment> Comments { get; set; }

        public Issue()
        {
            Id = Guid.NewGuid();
            CreationDate = DateTime.UtcNow;
            LastModifiedDate = DateTime.UtcNow;
            Status = Status.Open;
            Tags = new List<string>();
            Comments = new List<Comment>();
        }
    }
}