public class NightTimeAnalysisStrategy implements AnalysisStrategy {
    @Override
    public boolean isMotionSuspicious(MotionEvent event) {
        // At night, motion in certain locations is considered suspicious
        return event.isDetected() &&
                (event.getLocation().equals("entry") ||
                        event.getLocation().equals("window"));
    }
}