import commands.CreateIssueCommand;
import enums.Priority;
import models.Issue;
import models.IssueRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        IssueRepository repo = new IssueRepository();
        Issue newIssue = new Issue("Syntax error", "Details", Priority.HIGH);
        CreateIssueCommand createIssueCommand = new CreateIssueCommand(repo, newIssue);
        createIssueCommand.execute();
    }
}