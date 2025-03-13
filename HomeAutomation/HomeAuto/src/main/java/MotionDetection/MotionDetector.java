package MotionDetection;

import Core.Observer;

public class MotionDetector implements Observer{

    private boolean motionDetected;

    public void update(String eventType, Object value){
        if(eventType.equals("motionEvent")){
            this.motionDetected= (boolean) value;
        }
    }

    public boolean isMotionDetected(){
        return motionDetected;
    }
}
