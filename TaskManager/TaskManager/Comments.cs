using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    public class Comments
    {
        public int id;
        public string content;
        public string author;
        public DateTime CreatedAt;

        public Comments(int id, string content, string author)
        {
            this.id = id;
            this.content = content;
            this.author = author;
            //this.CreatedAt = DateTime.Now;
        }
    }
}
