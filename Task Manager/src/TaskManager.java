public class TaskManager {
    private CommandHistory commandHistory;
    private IssueRepository issueRepository;
    private StatisticsCollector statisticsCollector;

    public TaskManager(IssueRepository issueRepository, StatisticsCollector statisticsCollector) {
        this.issueRepository = issueRepository;
        this.statisticsCollector = statisticsCollector;
        this.commandHistory = new CommandHistory();
    }

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    public void undoCommand() {
        if (!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
        }
    }

    public void redoCommand() {
        if (!commandHistory.isEmpty()) {
            Command command = commandHistory.peek();
            command.execute();
        }
    }
}
