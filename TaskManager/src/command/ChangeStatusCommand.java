package command;

import model.Issue;
import model.Status;
import repository.IssueRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeStatusCommand implements Command {
    private final Issue issue;
    private final Status newStatus;
    private final Status oldStatus;
    private final IssueRepository repository;
    private final String timestamp;



    public ChangeStatusCommand(Issue issue, Status newStatus) {

        this.issue = issue;
        this.newStatus = newStatus;
        this.oldStatus = issue.getStatus();
        this.repository = IssueRepository.getInstance();
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    
    @Override
    public void execute() {
        issue.setStatus(newStatus);

        repository.updateIssue(issue);
    }
    
    @Override
    public void undo() {
        issue.setStatus(oldStatus);
        repository.updateIssue(issue);
    }
    
    @Override
    public String getDescription() {
        return "Changed status of issue: " + issue.getTitle() + " from " + oldStatus + " to " + newStatus;
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