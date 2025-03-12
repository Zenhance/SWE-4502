public class MotionDetector implements Observer{
    public void update(EnvironmentState state){
        boolean motionDetected=(Boolean) state.getState("motion");
        if(motionDetected){
            System.out.println("Motion detected!");
        }
    }
}
