using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace labfinal_210042111
{
    public class AddCommentCommand: ICommand
    {
        private IssueRepository repository;
        private Issue issue;
        private Comment comment;
        public AddCommentCommand(IssueRepository repository, Issue issue, Comment comment)
        {
            this.repository = repository;
            this.issue = issue;
            this.comment = comment;
        }
       
        public void Execute()
        {
            issue.AddComments(comment);
        }
     
    public string undo()
        {
            return "sucess";
            // Code to remove the last comment
        }
    }
}
