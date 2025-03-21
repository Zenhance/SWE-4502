import org.junit.Test;

public class CommandPatternTests {

    @Test
    public void StatisticsCollector_ShouldTrackCommandCounts() {
        CommandExecutor executor = new CommandExecutor();
        Command cmd1 = new CreateIssueCommand("Create Issue A");
        Command cmd2 = new CreateIssueCommand("Create Issue B");

        executor.executeCommand(cmd1);
        executor.executeCommand(cmd1);
        executor.executeCommand(cmd2);

        assertEquals(2, executor.getStatistics().getCommandCount("Create Issue A"));
        assertEquals(1, executor.getStatistics().getCommandCount("Create Issue B"));
    }

    @Test
    public void Logger_ShouldStoreCommandHistoryLogs() {
        CommandExecutor executor = new CommandExecutor();
        Command cmd1 = new CreateIssueCommand("Create Task X");
        Command cmd2 = new CreateIssueCommand("Create Task Y");

        executor.executeCommand(cmd1);
        executor.executeCommand(cmd2);

        assertTrue(executor.getLogger().getLogs().contains("Create Task X"));
        assertTrue(executor.getLogger().getLogs().contains("Create Task Y"));
    }

    @Test
    public void MultipleObservers_ShouldAllBeNotified() {
        CommandExecutor executor = new CommandExecutor();
        IssueObserver observer1 = new IssueObserver("Observer 1");
        IssueObserver observer2 = new IssueObserver("Observer 2");

        executor.addObserver(observer1);
        executor.addObserver(observer2);

        Command cmd = new CreateIssueCommand("Notify Test");
        executor.executeCommand(cmd);

        assertTrue(observer1.isNotified());
        assertTrue(observer2.isNotified());
    }
}