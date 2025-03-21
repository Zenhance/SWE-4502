import java.time.LocalDateTime;
import java.util.*;

public class Logger {
    private List<String> logs = new ArrayList<>();

    public void log(String msg) {
        logs.add(LocalDateTime.now() + " - " + msg);
    }

    public List<String> getLogs() {
        return logs;
    }
}
