package Lab_final_210042166.Task_Management_System.Create_Issue;

import Lab_final_210042166.Task_Management_System.Interface.Command;
import Lab_final_210042166.Task_Management_System.Issue.Issue;
import Lab_final_210042166.Task_Management_System.Issue_Repository.IssueRepository;

public class CreateIssueCommand implements Command {
    private Issue issue;
    private IssueRepository repository;


    public CreateIssueCommand(Issue issue, IssueRepository repository) {
        this.issue = issue;
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.addIssue(issue);
    }

    @Override
    public void undo() {
        repository.removeIssue(issue.getId());
    }

}
