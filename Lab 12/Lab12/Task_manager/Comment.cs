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
   Inprogress,
    UnderReview,
    Resolved,
    Closed
}

namespace Task_manager
{
    public class Comment
    {
       public int id;
       public string content;
       public string Author;
       public DateTime CreatedAt;

      public Comment(int id, string content, string Author, DateTime CreatedAt)
        {
            this.id = id;
            this.content = content;
            this.Author = Author;
            this.CreatedAt = CreatedAt;
        }


    }
}
