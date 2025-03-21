package labFinal_164.command;

import labFinal_164.model.Issue;
import labFinal_164.repository.IssueRepository;

public class CreateIssueCommand implements ICommand {
    private final IssueRepository repository;
    private final Issue issue;
    private final String description;

    public CreateIssueCommand(IssueRepository repository, Issue issue) {
        this.repository = repository;
        this.issue = issue;
        this.description = "Create issue: " + issue.getId(); // Initialize AFTER issue is set
    }


    @Override
    public void execute() { repository.addIssue(issue); }
    @Override
    public void undo() { repository.deleteIssue(issue.getId()); }
    @Override
    public String getType() { return "CREATE"; }
    @Override
    public String getDescription() { return description; }




}
