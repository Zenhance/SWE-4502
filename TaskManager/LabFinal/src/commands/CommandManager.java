package commands;

import interfaces.ICommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandManager {
    private final List<ICommand> commandHistory = new ArrayList<>();

    public void executeCommand(ICommand command) {
        commandHistory.add(command);
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            ICommand cmd = commandHistory.get(commandHistory.size()-1);
            cmd.undo();
        }
    }

    public List<ICommand> getCommandHistory() {
        return commandHistory;
    }
}
