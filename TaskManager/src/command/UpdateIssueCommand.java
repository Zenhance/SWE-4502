package command;

import model.Issue;
import repository.IssueRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateIssueCommand implements Command {
    private final Issue newIssue;
    private final Issue oldIssue;
    private final IssueRepository repository;
    private final String timestamp;
    
    public UpdateIssueCommand(Issue issue) {
        this.newIssue = issue;
        this.repository = IssueRepository.getInstance();
        this.oldIssue = repository.getIssue(issue.getId()) != null ? 
                repository.getIssue(issue.getId()).clone() : null;
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    
    @Override
    public void execute() {
        if (oldIssue != null) {
            repository.updateIssue(newIssue);
        }
    }
    
    @Override
    public void undo() {
        if (oldIssue != null) {
            repository.updateIssue(oldIssue);
        }
    }
    
    @Override
    public String getDescription() {
        return "Updated issue: " + newIssue.getTitle() + " with ID: " + newIssue.getId();
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