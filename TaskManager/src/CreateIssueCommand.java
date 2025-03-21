public class CreateIssueCommand implements ICommand {


    @Override
    public void execute() {
        System.out.println("Create Issue");

    }


    @Override
    public void undo() {
        System.out.println("Undo Issue");


    }
}
