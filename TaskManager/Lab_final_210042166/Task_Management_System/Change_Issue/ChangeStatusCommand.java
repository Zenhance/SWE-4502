package Lab_final_210042166.Task_Management_System.Change_Issue;

import Lab_final_210042166.Task_Management_System.Enum.Status;
import Lab_final_210042166.Task_Management_System.Interface.Command;
import Lab_final_210042166.Task_Management_System.Issue.Issue;
import Lab_final_210042166.Task_Management_System.Issue_Repository.IssueRepository;

public class ChangeStatusCommand implements Command {
    private Issue issue;
    private Issue oldStatus;
    private Status newStatus;
    private IssueRepository repository;

    public ChangeStatusCommand(Issue issue, Status newStatus, IssueRepository repository) {
        this.issue = issue;
        this.oldStatus = issue;
        this.newStatus = newStatus;
        this.repository = repository;
    }



    @Override
    public void execute() {
        issue.setStatus(newStatus);
        repository.updateIssue(issue);
    }

    @Override
    public void undo() {
        issue.setStatus(oldStatus.getStatus());
        repository.updateIssue(issue);
    }
}
