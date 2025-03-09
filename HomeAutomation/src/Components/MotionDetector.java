package Components;

import Core_Models.IObserver;
import Core_Models.SystemState;

public class MotionDetector implements IObserver {
    public boolean motionDetected;
    public long lastDetectedTime;

    public void update(SystemState state) {
        this.motionDetected = state.motionDetected;
        if (motionDetected)
        {
            lastDetectedTime = System.currentTimeMillis();
            logMotion();
        }
        else {
            System.out.println("Motion not detected.");
        }
    }

    private void logMotion() {
        System.out.println("Motion detected at: " + lastDetectedTime);
    }

    public boolean isMotionDetected(){
        return motionDetected;
    }

}
