package commands;

import interfaces.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private final List<Command> commandHistory = new ArrayList<>();

    public void executeCommand(Command command) {
        commandHistory.add(command);
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            Command cmd = commandHistory.get(commandHistory.size()-1);
            cmd.undo();
        }
    }

    public List<Command> getCommandHistory() {

        return commandHistory;
    }
}
