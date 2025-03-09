package motion;

import java.util.ArrayList;
import java.util.List;

public class ActivityLog {
    private List<String> log = new ArrayList<>();

    public void logActivity(String activity) {
        log.add(activity);
    }

    public List<String> getLog() {
        return log;
    }
}
