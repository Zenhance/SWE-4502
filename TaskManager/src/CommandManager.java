public class CommandManager {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public Issue executeCommand(){
        return command.execute();
    }
}