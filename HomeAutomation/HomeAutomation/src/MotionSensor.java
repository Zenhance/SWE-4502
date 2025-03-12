public class MotionSensor implements Observer {
    private boolean motionDetected = false;

    @Override
    public void update(String state, Object value) {
        if (state.equals("MOTION")) {
            motionDetected = (Boolean) value;
            System.out.println("Motion Sensor: Motion detected? " + motionDetected);
        }
    }
}
