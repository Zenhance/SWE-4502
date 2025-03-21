package command;

import model.Issue;
import repository.IssueRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateIssueCommand implements Command {
    private final Issue issue;
    private final IssueRepository repository;
    private final String timestamp;
    
    public CreateIssueCommand(Issue issue) {
        this.issue = issue;
        this.repository = IssueRepository.getInstance();
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    
    @Override
    public void execute() {
        repository.addIssue(issue);
    }
    
    @Override
    public void undo() {
        repository.removeIssue(issue.getId());
    }
    
    @Override
    public String getDescription() {
        return "Created issue: " + issue.getTitle() + " with ID: " + issue.getId();
    }
    
    @Override
    public String getTimestamp() {
        return timestamp;
    }
    
    @Override
    public CommandType getType() {
        return CommandType.Create;
    }
}