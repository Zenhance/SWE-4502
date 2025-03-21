using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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

namespace TaskManager
{
    using System;

    public class Comment
    {
        public int Id { get; set; }
        public string Content { get; set; }
        public string Author { get; set; }
        public DateTime CreatedAt { get; set; }

        
        public Comment(int id, string content, string author)
        {
            Id = id;
            Content = content;
            Author = author;
            CreatedAt = DateTime.Now;
        }

        public Comment() { }
    }


}