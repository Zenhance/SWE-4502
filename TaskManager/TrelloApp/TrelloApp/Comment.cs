using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TrelloApp
{
    public class Comment
    {
        public int id;
        public string content;
        public string author;
        public int createdAt;

        public Comment (int id, string content, string author, int createdAt)
        {
            this.id = id;
            this.content = content;
            this.author = author;
            this.createdAt = createdAt;
        }
    }
}
