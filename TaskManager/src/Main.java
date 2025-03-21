public class Main {

    public static User user = new User("Adid");
    public static Issue issue = new Issue("101","Issue 1" , PRIORITY.High, STATUS.Open, user);
    public static IssueRepository repository= new IssueRepository(issue);
    static CreateCommand create =new CreateCommand(repository,issue);
    UpdateCommand update = new UpdateCommand(issue, "Updated Comment", PRIORITY.Low);
    ChangeCommand change = new ChangeCommand(issue, STATUS.Closed);
    static CommandManager manager = new CommandManager();


    public static void main(String[] args) {
        manager.setCommand(create);
        Issue issue1 = manager.executeCommand();
        System.out.print(issue1.getId() + " " + issue1.getTitle());
    }
}