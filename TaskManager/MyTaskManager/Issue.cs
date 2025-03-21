using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyTaskManager
{
    public class Issue : ICloneable
    {
        public int Id { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public Priority Priority { get; set; }
        public Status Status { get; set; }
        public DateTime CreationDate { get; set; }
        public DateTime LastModifiedDate { get; set; }
        public string AssignedTo { get; set; }
        public List<string> Tags { get; set; }
        public List<Comment> Comments { get; set; }

        public Issue(int id, string title, string description, Priority priority)
        {
            Id = id;
            Title = title;
            Description = description;
            Priority = priority;
            Status = Status.Open;
            CreationDate = DateTime.Now;
            LastModifiedDate = DateTime.Now;
            Tags = new List<string>();
            Comments = new List<Comment>();
        }

        public object Clone()
        {
            Issue clone = new Issue(Id, Title, Description, Priority)
            {
                Status = this.Status,
                CreationDate = this.CreationDate,
                LastModifiedDate = this.LastModifiedDate,
                AssignedTo = this.AssignedTo
            };

            clone.Tags = new List<string>(this.Tags);

            clone.Comments = new List<Comment>();

            foreach (var comment in Comments)
            {
                clone.Comments.Add((Comment)comment.Clone());
            }

            return clone;
        }
    }
}
