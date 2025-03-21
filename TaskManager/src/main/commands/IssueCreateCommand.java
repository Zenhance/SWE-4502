package main.commands;

import main.core.Issue;

public class IssueCreateCommand extends Command{
    private Issue issue;
    private String title;
    private String description;
    private String assignedTo;
    private CommandHistory commandHistory;

    public IssueCreateCommand(String _title, String _description, String _assignedTo) {
        super();
        this.title = _title;
        this.description = _description;
        this.assignedTo = _assignedTo;
        this.commandHistory = new CommandHistory();
    }

    @Override
    public void execute() {
        issue = new Issue(title, description, assignedTo);
        commandHistory.PushToMainStack(issue);
    }

    @Override
    public void undo() {
        
    }
}
