package commands;

import interfaces.Command;
import models.Issue;
import models.IssueRepository;

public class CreateIssueCommand extends Command {
    private IssueRepository issueRepo;
    private Issue issue;
    public CreateIssueCommand(IssueRepository issueRepo, Issue issue,String desc, String type){
        super(desc, type);
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
