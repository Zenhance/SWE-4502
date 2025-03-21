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
        public string comment;
        public string author;
        public DateTime CreatedAt;

        public Comments(int id, string comment, string author)
        {
            this.id = id;
            this.comment = comment;
            this.author = author;
            //this.CreatedAt = DateTime.Now;
        }
    }
}
