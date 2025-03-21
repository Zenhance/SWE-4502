public class CreateIssueCommand implements ICommand {

    private final IssueRepo repository;
    private final Issue issue;

    public CreateIssueCommand(IssueRepo repository, String title, String desc, String
            priority) {
        this.repository = repository;
        this.issue = new Issue(repository.getIssueCount() + 1, title, desc, priority);
    }

    @Override
    public void execute() {
        repository.addIssue(issue);
        System.out.println("Created: " + issue);
    }

    @Override
    public void undo() {
        repository.removeIssue(issue.getId());
        System.out.println("Undo Create: Removed issue " + issue.getId());
    }

    @Override
    public String getDescription() {
        return "Create Issue: " + issue.getId();
    }
}




