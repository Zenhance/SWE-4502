package Lab_Final_210042150.Task_Management_System.Command;

import Lab_Final_210042150.Task_Management_System.Enums.commandType;
import Lab_Final_210042150.Task_Management_System.Models.DomainModel.Issue;
import Lab_Final_210042150.Task_Management_System.Repositories.IssueRepository;

public class CreateIssueCommand extends AbstractCommand{
    private IssueRepository repository;
    private Issue issue;

    public CreateIssueCommand(Issue issue,IssueRepository repository)
    {
        super("Create Issue: "+issue.getTitle(), commandType.Create);
        this.issue = issue;
        this.repository = repository;
    }

    @Override
    public void execute()
    {
        repository.save(issue);
    }

    @Override
    public void undo()
    {
        repository.delete(issue.getId());
    }

}
