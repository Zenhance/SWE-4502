package commands;

import interfaces.ICommand;
import models.Comment;
import models.Issue;
import models.IssueRepository;

public class AddCommentToIssueCommand implements ICommand {
    private IssueRepository issueRepo;
    private Issue issue;
    public AddCommentToIssueCommand(IssueRepository issueRepo, Issue issue, Comment comment){
        this.issueRepo = issueRepo;
        this.issue = issue;
    }
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
