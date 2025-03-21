using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{

    public class Issue : ICloneable
    {
        public int Id { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public Priority Priority { get; set; }
        public Status Status { get; set; } = Status.Open;
        public DateTime CreationDate { get; set; } = DateTime.Now;
        public DateTime LastModifiedDate { get; set; } = DateTime.Now;
        public string AssignedTo { get; set; }
        public List<string> Tags { get; set; } = new List<string>();
        public List<Comment> Comments { get; set; } = new List<Comment>();

        public object Clone()
        {
            return new Issue
            {
                Id = this.Id,
                Title = this.Title,
                Description = this.Description,
                Priority = this.Priority,
                Status = this.Status,
                CreationDate = this.CreationDate,
                LastModifiedDate = this.LastModifiedDate,
                AssignedTo = this.AssignedTo,
                Tags = new List<string>(this.Tags),
                Comments = new List<Comment>(this.Comments)
            };
        }

    }

}

