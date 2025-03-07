package invoker;
import commands.Command;
import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {
    private List<Command> commandHistory = new ArrayList<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.add(command);
    }
}
