package Lab_final_210042166.Task_Management_System.Update_Issue;

import Lab_final_210042166.Task_Management_System.Interface.Command;
import Lab_final_210042166.Task_Management_System.Issue.Issue;
import Lab_final_210042166.Task_Management_System.Issue_Repository.IssueRepository;

public class UpdateIssueCommand implements Command {
    private Issue oldIssue;
    private Issue newIssue;
    private IssueRepository repository;

    @Override
    public void execute()
    {
        repository.updateIssue(newIssue);
    }
    @Override
    public void undo()
    {
        repository.updateIssue(oldIssue);
    }

}
