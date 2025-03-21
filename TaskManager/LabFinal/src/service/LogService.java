package service;
import command.Command;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogService {
    private final List<LogEntry> logs = new ArrayList<>();

    public void logCommand(Command command) {
        LogEntry entry = new LogEntry(
                command.getTimestamp(),
                command.getDescription(),
                command.getType()
        );
        logs.add(entry);
        System.out.println("LOG: " + entry);
    }

    public List<LogEntry> getLogs() {
        return Collections.unmodifiableList(logs);
    }

}