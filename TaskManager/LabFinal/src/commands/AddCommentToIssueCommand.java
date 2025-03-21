package commands;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import interfaces.Command;
import models.Comment;
import models.Issue;
import models.IssueRepository;

public class AddCommentToIssueCommand extends Command {
    private IssueRepository issueRepo;
    private Issue issue;
    private Comment comment;
    public AddCommentToIssueCommand(IssueRepository issueRepo, String issueId, Comment comment,String desc, String type){
        super(desc, type);
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
