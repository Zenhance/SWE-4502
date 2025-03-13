import java.util.HashMap;
import java.util.Map;

public class MotionDetector implements IObserver {
    private Map<String, Integer> motionCounts = new HashMap<>();

    @Override
    public void update(SystemState state) {

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


}
