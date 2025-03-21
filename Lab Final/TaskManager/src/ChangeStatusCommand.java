public class ChangeStatusCommand implements Command{
    private IssueService issueService;
    private int issueId;
    private String status;


    public ChangeStatusCommand(IssueService issueService, int issueId, String status) {
        this.issueService = issueService;
        this.issueId = issueId;
        this.status = status;
    }

    @Override
    public void execute() {
        issueService.addStatus(issueId, status);
    }

    @Override
    public void undo() {

    }


}
