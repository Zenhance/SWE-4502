using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Reflection.Metadata;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace TrelloApp
{
    public class commentCommand : ICommand
    {
        public string description { get; set; }
        public int timestamp { get; set; }
        public CommandType type { get; set; }
        public IssueRepository repository;
        public int issueId;
        public int commentId;
        public Comment comment;
        public commentCommand(string description, int dateTime, CommandType cmd, 
            IssueRepository repository, int issueId, int commentId, string content,
            string author, int createdAt) 
        {
            this.description = description;
            this.timestamp = timestamp;
            this.type = cmd;
            this.repository = repository;
            this.issueId = issueId;
            this.commentId = commentId;
            this.comment = new Comment(commentId, content, author, createdAt);
        }

        public void execute()
        {
            Issue issue = repository.getIssue(issueId);
            if (issue != null)
            {
                issue.comments.Add(comment);
                repository.updateIssue(issue);
            }
        }
        public void undo()
        {
            Console.WriteLine("loading.");
        }
        
    }
}
