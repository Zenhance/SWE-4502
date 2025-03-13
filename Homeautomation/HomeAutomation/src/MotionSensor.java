public class MotionSensor implements Observer{
    private boolean motionDetected;
    @Override
    public void update(EnvironmentalState state) {
        this.motionDetected = state.isMotionDetected();
        if (motionDetected) {
            System.out.println("Motion detected! Logging activity...");
        }

    }
    public boolean isMotionDetected() {
        return motionDetected;
    }
}