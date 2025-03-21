class CreateCommand implements ICommand {
    private final IssueRepository repo = IssueRepository.getInstance();
    private final Issue issue;

    public CreateCommand(Issue issue) {
        this.issue = issue;
    }

    public void execute() {
        repo.createIssue(issue);
        System.out.println("The issue has been created successfully " + issue);
    }

    public void undo() {
        repo.removeIssue(issue.getId());
        System.out.println("Undo: Issue removed: " + issue);
    }
}