package command;

import model.Comment;
import model.Issue;
import repository.IssueRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCommentCommand implements Command {
    private final Issue issue;
    private final Comment comment;
    private final IssueRepository repository;
    private final String timestamp;
    
    public AddCommentCommand(Issue issue, Comment comment) {
        this.issue = issue;
        this.comment = comment;
        this.repository = IssueRepository.getInstance();
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    
    @Override
    public void execute() {
        issue.addComment(comment);
        repository.updateIssue(issue);
    }





    @Override
    public void undo() {
        // ensuring the latest version
        Issue currentIssue = repository.getIssue(issue.getId());
        if (currentIssue != null) {
            Issue clonedIssue = currentIssue.clone();
            // remove the comment by filtering it out
            clonedIssue.getComments().removeIf(c -> c.getId().equals(comment.getId()));
            repository.updateIssue(clonedIssue);
        }
    }
    
    @Override
    public String getDescription() {
        return "Added comment to issue: " + issue.getTitle() + " by " + comment.getAuthor();
    }


    
    @Override
    public String getTimestamp() {
        return timestamp;
    }
    
    @Override
    public CommandType getType() {
        return CommandType.Update;
    }
}