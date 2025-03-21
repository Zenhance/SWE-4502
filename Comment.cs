using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dpfinal_200042152
{
    public class Comment
    {
        public int Id;
        public string Content;
        public string Author;
        public DateTime CreatedAt;


        public Comment(int _id, string _content,string _author, DateTime _createdAt) 
        { 
        
            Id = _id;
            Content = _content;
            Author = _author;
            CreatedAt = _createdAt;
        
        }
         
        public Comment(Comment original) 
        
        { 
            Id=original.Id;
            Content = original.Content;
            Author = original.Author;
            CreatedAt = original.CreatedAt;
        
        }
    }
}
