package commands;

import interfaces.ICommand;
import models.Issue;
import models.IssueRepository;

public class CreateIssueCommand implements ICommand {
    private IssueRepository issueRepo;
    private Issue issue;
    public CreateIssueCommand(IssueRepository issueRepo, Issue issue){
        this.issueRepo = issueRepo;
        this.issue = issue;
    }
    @Override
    public void execute() {
        issueRepo.addIssue(issue);
    }

    @Override
    public void undo() {

    }
}
