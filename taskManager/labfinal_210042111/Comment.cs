using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace labfinal_210042111
{
    public class Comment
    {
        public int id { get; set; }
        public string Content { get; set; }
        public string Author { get; set; }
        public DateTime CreatedAt { get; set; }

        public Comment(int id, string content, string author)
        {
            this.id = id;
            this.Content = content;
            this.Author = author;
            this.CreatedAt = DateTime.Now;
        }

      
    }
}
