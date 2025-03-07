package observers;

import models.EnvironmentState;

public class MotionDetector implements Observer {
    private boolean motionDetected;

    @Override
    public void update(EnvironmentState environmentState){
        this.motionDetected = environmentState.isMotionDetected();
        if (motionDetected) {
            System.out.println("Motion detected!");
        } else {
            System.out.println("No motion detected.");
        }
    }
}
