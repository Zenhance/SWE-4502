package Issue2;

public class NightTimeAnalysisStrategy implements AnalysisStrategy {
    @Override
    public boolean isMotionSuspicious(MotionEvent event) {

        return event.isDetected() &&
                (event.getLocation().equals("entry") ||
                        event.getLocation().equals("window"));
    }
}