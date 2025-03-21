public class ActionHandler {
    public static void executeCommand(ICommand createIssue) {
        createIssue.execute();
    }
}
