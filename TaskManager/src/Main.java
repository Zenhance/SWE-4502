import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IssueRepository repository = new IssueRepository();
        Log_Operation logger = new Log_Operation();
        StatisticsCollector statistics = new StatisticsCollector();


        Issue issue1 = new Issue("210042118", "Fix Bug", "Fix the login bug", Priority.HIGH, "Alice", Arrays.asList("bug", "login"));
        Command createCommand = new Create_Issue(repository, issue1);
        createCommand.execute();
        logger.log("Create", "Created issue with ID 210042118");
        statistics.incrementCommandCount("Create");


        Issue updatedIssue = new Issue("210042118", "Fix Bug", "Fix the login bug and improve performance", Priority.CRITICAL, "Alice", Arrays.asList("bug", "login"));
        Command updateCommand = new Update_Issue(repository, "1", updatedIssue);
        updateCommand.execute();
        logger.log("Update", "Updated issue with ID 210042118");
        statistics.incrementCommandCount("Update");


        Command changeStatusCommand = new Change_Issue_Status(repository, "1", Status.IN_PROGRESS);
        changeStatusCommand.execute();
        logger.log("Update", "Changed status of issue with ID 210042118 to IN_PROGRESS");
        statistics.incrementCommandCount("Update");


        System.out.println("Logs:");
        for (String log : logger.getLogs()) {
            System.out.println(log);
        }

        statistics.printStatistics();
    }
}