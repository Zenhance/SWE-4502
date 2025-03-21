public class IssueCommand extends Command {
    private  IssueRepository issueRepository;
    private  Issue issue;

    public IssueCommand(IssueRepository issueRepository, Issue issue) {
        this.issueRepository = issueRepository;
        this.issue = issue;
    }

    @Override
    public void execute() {
        issueRepository.addIssue(issue);
    }

    @Override
    public void undo() {
        issueRepository.removeIssue(issue.getId());
    }
}
