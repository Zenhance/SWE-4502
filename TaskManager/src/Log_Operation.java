import java.util.*;

public class Log_Operation {
    private List<String> logs = new ArrayList<>();

    public void log(String operationType, String description) {
        String logEntry = "[" + new Date() + "] " + operationType + ": " + description;
        logs.add(logEntry);
    }

    public List<String> getLogs() {
        return logs;
    }
}