package Class.Commands;
import Class.*;
import Predefinedvalues.Status;

public class UpdateStatusCommand implements  Command{

    private IssueRepository issueRepository;
    private Issue issue;

    private Status status;


    public UpdateStatusCommand(IssueRepository issueRepository, Issue issue, Status status){
        this.issueRepository=issueRepository;
        this.issue=issue;
        this.status=status;
    }
    @Override
    public void Execute() {
        issueRepository.updateStatus(issue,status);
    }

    @Override
    public void Undo() {
        //undo
    }
}
