public class MotionDetector implements IObserver{
    public boolean motionDetected;
    public long lastDetectedTime;

    public void update(SystemState state) {
        this.motionDetected = state.motionDetected;
        if (motionDetected)
        {
            lastDetectedTime = System.currentTimeMillis();
            System.out.println("Motion detected at: " + lastDetectedTime);
        }
        else
        {
            System.out.println("Motion not detected.");
        }
    }


}
