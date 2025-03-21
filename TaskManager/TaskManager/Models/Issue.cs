using System;
using System.Collections.Generic;

namespace TaskManager.Models
{
    public class Issue
    {
        public int Id { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public Priority Priority { get; set; }
        public Status Status { get; set; }
        public DateTime CreationDate { get; set; }
        public DateTime LastModifiedDate { get; set; }
        public string AssignedTo { get; set; }
        public List<string> Tags { get; set; } = new List<string>();
        public List<Comment> Comments { get; set; } = new List<Comment>();
    }
}