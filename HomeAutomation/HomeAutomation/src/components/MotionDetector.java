package components;
import core.Sensor;

import java.util.List;

public class MotionDetector implements Sensor
{
    private List<String> motionLog; //list of motion logs
    private int suspiciousActivityThreshold;

    @Override
    public void onStateChange(String newState) //when the state changes (e.g. motion detected)
    {
        if(newState.contains("motion"))
        {
            logActivity(newState); //log the activity
            analyzePattern(); //analyze the pattern of the motion (eg. if the motion is detected more than 5 times, it is considered suspicious)
        }
    }

    private void logActivity(String motionData)
    {
        motionLog.add(motionData);
        System.out.println("Motion detected! Logged: " + motionData);
    }

    private void analyzePattern()
    {
        if (motionLog.size() > suspiciousActivityThreshold) {
            System.out.println("Suspicious activity detected! Alerting security.");
        }
        
    }

    //Tracks location and time of detected movements
    public void trackMovement(String location, String time)
    {
        System.out.println("Movement detected at " + location + " at " + time);
    }



}
