package commands;

import db.*;
import models.CommandType;
import models.Issue;
import models.Priority;;

public class CreateIssueCommand extends Command {
    private IssueReposity repository;
    private Issue issue;
    
    public CreateIssueCommand(IssueReposity repository, Issue issue) {
        super("Create issue: " + issue.getTitle(), CommandType.CREATE);
        this.repository = repository;
        this.issue = issue;
    }
    
    @Override
    public void execute() {
        repository.addIssue(issue);
    }
    
    @Override
    public void undo() {
        repository.removeIssue(issue);
    } 
}
