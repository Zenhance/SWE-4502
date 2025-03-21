import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger {
    private List<String> logs = new ArrayList<>();

    public void logOperation(String description) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        logs.add(timestamp + " - " + description);
    }

    public List<String> getLogs() {
        return logs;
    }
}
