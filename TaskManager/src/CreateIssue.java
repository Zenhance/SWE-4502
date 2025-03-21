class CreateIssue implements Command {
    public IssueRepository repository;
    private final Issue issue;
    public CreateIssue(IssueRepository r, String title, String desc, Priority
            priority) {
        this.repository = r;
        this.issue = new Issue(r.getIssueCount() + 1, title, desc, priority);
    }

    public void execute() {
        repository.addIssue(issue);
        System.out.println("Created: " + issue);
    }

    public void undo() {
        repository.removeIssue(issue.getId());
        System.out.println("Undo Create: Removed issue " + issue.getId());
    }

    public String getDescription() {
        return "Create Issue: " + issue.getId();
    }
}
