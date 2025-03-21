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
    public class Comment
    {
        public int Id;
        public string Content;
        public string Author;
        public DateTime CreatedAt;


        public Comment(int Id, string Content, string Author, DateTime CreatedAt)
        {
            this.Id = Id;
            this.Content = Content;
            this.Author = Author;
            this.CreatedAt = CreatedAt;
        }


    }

}