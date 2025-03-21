import command.CommandManager;
import command.CreateIssueCommand;
import model.Comment;
import model.Issue;
import model.Priority;
import notification.NotificationService;
import repository.IssueRepository;

public class Main {
    public static void main(String[] args) {
        // initialize
        IssueRepository repository = IssueRepository.getInstance();
        CommandManager commandManager = CommandManager.getInstance();
        NotificationService notificationService = NotificationService.getInstance();
        // register observer
        commandManager.addObserver(notificationService);
        
        // new issue
        Issue issue = new Issue("Fix login bug", "Users cannot login with correct credentials", Priority.High);
        // tags
        issue.addTag("bug");
        issue.addTag("authentication");

        // assignee
        issue.setAssignedTo("Taki Tajwaruzzaman Khan");
        
        // add to the repository
        CreateIssueCommand createCommand = new CreateIssueCommand(issue);
        
        // execute
        System.out.println("Executing create issue command...");
        commandManager.executeCommand(createCommand);
        
        // print and verify
        System.out.println("\nIssue count in repository: " + repository.getIssueCount());
        System.out.println("Issue details:\n" + 
                "ID: " + issue.getId() + "\n" +
                "Title: " + issue.getTitle() + "\n" +
                "Priority: " + issue.getPriority() + "\n" +
                "Status: " + issue.getStatus() + "\n" +
                "Assigned To: " + issue.getAssignedTo() + "\n" +
                "Tags: " + issue.getTags());
        
        // add a comment
        Comment comment = new Comment("I've identified the root cause", "Zadid Bin Azad");
        issue.addComment(comment);
        System.out.println("\nAdded comment to issue: " + comment.getContent() + " by " + comment.getAuthor());
        
        // undo
        System.out.println("\nUndoing create issue command...");
        commandManager.undoCommand();

        System.out.println("Issue count in repository after undo: " + repository.getIssueCount());
        
        // redo
        System.out.println("\nRedoing create issue command...");
        commandManager.redoCommand();

        System.out.println("Issue count in repository after redo: " + repository.getIssueCount());
        
        // command statistics display
        System.out.println("\nCommand Statistics:");
        System.out.println("Total commands executed: " + commandManager.getStatistics().getTotalCommandCount());
        System.out.println("Create commands executed: " + commandManager.getStatistics().getCommandCount(command.CommandType.Create));
        
        // logs
        System.out.println("\nCommand Logs:");
        for (command.CommandLog log : commandManager.getCommandLogs()) {
            System.out.println(log);
        }
    }
}