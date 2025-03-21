package commands;

import db.IssueReposity;
import models.CommandType;
import models.Comment;
import models.Issue;
import java.time.LocalDateTime;
import java.util.UUID;

public class AddCommentCommand extends Command {
    private IssueReposity repository;
    private String issueId;
    private String content;
    private String author;
    private String commentId;

    public AddCommentCommand(IssueReposity repository, String issueId, String content, String author) {
        super("Add comment to issue " + issueId, CommandType.UPDATE);
        this.repository = repository;
        this.issueId = issueId;
        this.content = content;
        this.author = author;
    }

    @Override
    public void execute() {
        Issue issue = repository.getIssue(issueId);
        if (issue != null) {
            Comment comment = new Comment();
            commentId = UUID.randomUUID().toString();
            comment.setId(commentId);
            comment.setContent(content);
            comment.setAuthor(author);
            comment.setCreatedAt(LocalDateTime.now());

            issue.getComments().add(comment);
            issue.setLastModifiedDate(LocalDateTime.now());
            repository.updateIssue(issue);
        }
    }

    @Override
    public void undo() {
        Issue issue = repository.getIssue(issueId);
        if (issue != null && commentId != null) {
            issue.getComments().removeIf(comment -> comment.getId().equals(commentId));
            issue.setLastModifiedDate(LocalDateTime.now());
            repository.updateIssue(issue);
        }
    }
}