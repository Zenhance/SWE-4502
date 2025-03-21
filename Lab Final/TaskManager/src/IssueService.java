import java.util.Date;

public class IssueService {
    private IssueRepository repository;
    private int nextId;

    public IssueService(IssueRepository repository) {
        this.repository = repository;
        this.nextId = 1;
    }

    public Issue createIssue(String title, String description, String priority) {
        Issue newIssue = new Issue(nextId++, title, description, "Open", priority, null, new Date(), new Date(), null, null);
        repository.addIssue(newIssue);
        return newIssue;
    }

    public Issue deleteIssue(int id) {
        Issue issue = repository.getIssue(id);
        if (issue == null) {
            return null;
        }
        repository.removeIssue(id);
        return issue;
    }

    public Issue updateIssue(int id, String title, String description, String priority) {
        Issue issue = repository.getIssue(id);
        if (issue == null) {
            return null;
        }
        issue.title = title;
        issue.description = description;
        issue.priority = priority;
        issue.LastModified = new Date();
        return issue;
    }

    public Issue addComment(int id, String content, String author) {
        Issue issue = repository.getIssue(id);
        if (issue == null) {
            return null;
        }
        Comment newComment = new Comment(nextId++, content, author, new Date());
        issue.addComment(newComment);
        issue.LastModified = new Date();
        return issue;
    }

    public Issue addStatus(int id, String status) {
        Issue issue = repository.getIssue(id);
        if (issue == null) {
            return null;
        }
        issue.status = status;
        issue.LastModified = new Date();
        return issue;
    }
}