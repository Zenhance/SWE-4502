using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TrelloApp
{
    public class Issue
    {
        public int id;
        public string title;
        public string description;
        public enum priority { Low, Medium, High, Critical };
        public priority priorityType;
        public enum status { Open, InProgress, UnderReview, Resolved };
        public status statusType;

        public int creationDate;
        public int updatedDate;

        public string assignedTo;
        public List<string> tags = new List<string>();
        public List<Comment> comments = new List<Comment>();

        public Issue(int id, string title, string description, priority priority, 
            status status,int creationDate) 
        {
            this.id = id;
            this.title = title;
            this.description = description;
            priorityType = priority;
            statusType = status;
            this.creationDate = creationDate;
        }

        public Issue()
        {
            
        }

        public void addComment(Comment comment)
        {
            comments.Add(comment);
        }
    }
}
