using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace labfinal_210042111
{
    public class UpdateIssueCommand
    {
        private IssueRepository repository;
        private Issue issue;
        public string newTitle;
        public string newDescription;
        public UpdateIssueCommand(IssueRepository repository, Issue issue, string newTitle, string newDescription)
        {
            this.repository = repository;
            this.issue = issue;
            this.newTitle = newTitle;
            this.newDescription = newDescription;
        }

        public void Execute()
        {

            issue.setTitle(newTitle);
            issue.setDescription(newDescription);

        }
        public void undo()
        {
            string title= issue.getTitle();
            string des = issue.getDescription();
            issue.undoTitle(title);
            issue.undoDescription(des);
            //traceback to previous version
        }

    }
}
