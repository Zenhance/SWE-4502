public class MotionDetector implements Observer {
    private boolean motionDetected = false;

    @Override
    public void update(EnvironmentState state) {
        Boolean motion = (Boolean) state.getState("motion");

        if (motion != null) {
            motionDetected = motion;
            if (motionDetected) {
                System.out.println("Motion detected!");
            }
        }
    }

    public boolean isMotionDetected() {
        return motionDetected;
    }
}
