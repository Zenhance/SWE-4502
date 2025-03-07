package Executors;

import Command.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    private List<Command> commands = new ArrayList<>();

    public void executeCommand(Command command) {
        commands.add(command);
        command.execute();
    }

    public void commandHistory() {
        System.out.println("\nCommand History");
        for (Command cmd : commands) {
            cmd.signature();
        }
    }
}
