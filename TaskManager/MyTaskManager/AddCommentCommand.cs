using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyTaskManager
{
    public class AddCommentCommand : Command
    {
        public IssueRepository repository;
        public int issueId;
        public Comment comment;

        public AddCommentCommand(IssueRepository repository, int issueId, string content, string author)
        {
            this.repository = repository;
            this.issueId = issueId;
            int commentId = repository.GetNextCommentId();
            this.comment = new Comment(commentId, content, author);
            this.Type = CommandType.Create;
            this.Description = $"Added comment to issue id {issueId}";
        }

        public override void Execute()
        {
            Issue issue = repository.GetIssue(issueId);
            if (issue != null)
            {
                issue.Comments.Add(comment);
                issue.LastModifiedDate = DateTime.Now;
                repository.UpdateIssue(issue);
            }
        }

        public override void Undo()
        {
            Issue issue = repository.GetIssue(issueId);
            if (issue != null)
            {
                foreach (var TempComment in issue.Comments)
                {
                    if (TempComment.Id == comment.Id) issue.Comments.Remove(TempComment);
                }
                
                issue.LastModifiedDate = DateTime.Now;
                repository.UpdateIssue(issue);
            }
        }
    }
}
