package commands;

import interfaces.ICommand;
import models.Comment;
import models.Issue;
import models.IssueRepository;

public class AddCommentToIssueCommand implements ICommand {
    private IssueRepository issueRepo;
    private Issue issue;
    private Comment comment;
    public AddCommentToIssueCommand(IssueRepository issueRepo, String issueId, Comment comment){
        this.issueRepo = issueRepo;
        this.issue = issueRepo.getIssue(issueId);
        this.comment = comment;
    }
    @Override
    public void execute() {
        issue.addComment(comment);
    }

    @Override
    public void undo() {
        issue.removeComment(comment);
    }
}
