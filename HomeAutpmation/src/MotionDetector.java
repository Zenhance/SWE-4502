import java.util.HashMap;
import java.util.Map;

public class MotionDetector implements IObserver {
    private Map<String, Integer> motionCounts = new HashMap<>();



    @Override
    public void update(SystemState state) {
        String location = state.getStateDescription();
        logMotion(location);
        analyzeMotionPatterns(location);
    }

    private void logMotion(String location) {
        System.out.println("Logging motion: " + location);
    }

    private void analyzeMotionPatterns(String location) {
        motionCounts.put(location, motionCounts.getOrDefault(location, 0) + 1);
        int count = motionCounts.get(location);

        if (count > 5) {
            System.out.println("Suspicious activity detected at " + location);
        } else {
            System.out.println("Normal motion activity detected at " + location);
        }
    }
    public int getMotionCount(String location) {
        return motionCounts.getOrDefault(location, 0);
    }


}
