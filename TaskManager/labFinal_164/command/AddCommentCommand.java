package labFinal_164.command;

import labFinal_164.model.Comment;
import labFinal_164.model.Issue;
import labFinal_164.repository.IssueRepository;

import java.util.UUID;

public class AddCommentCommand implements ICommand {
    private IssueRepository repository;
    private String issueId;
    private Comment comment;
    private String description;
    public AddCommentCommand(IssueRepository repo, String issueId, String content, String author) {
        this.repository = repo;
        this.issueId = issueId;
        this.comment = new Comment(UUID.randomUUID().toString(), content, author);
        this.description = "Added comment to issue " + issueId;
    }

    @Override
    public void execute() {
        Issue issue = repository.getIssue(issueId);
        if (issue != null) {
            issue.addComment(comment);
            repository.updateIssue(issue);
        }
    }

    @Override
    public void undo() {
        Issue issue = repository.getIssue(issueId);
        if (issue != null) {
            issue.getComment().remove(comment);
            repository.updateIssue(issue);
        }
    }

    @Override
    public String getType() { return "UPDATE"; }

    @Override
    public String getDescription() { return description; }



}
