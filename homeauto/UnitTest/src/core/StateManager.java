package core;
import java.util.ArrayList;
import java.util.List;

public class StateManager
{
    private static StateManager instance;
    private List<Sensor> sensors;
    private String environmentState;

    private StateManager()
    {
        sensors=new ArrayList<>();
    }

    public static StateManager getInstance() //singleton pattern
    {
        if(instance==null)
        {
            instance=new StateManager();
        }
        return instance;
    }

    public void registerSensor(Sensor sensor) //registering the sensor (eg. temperature sensor)
    {
        sensors.add(sensor);
    }

    public void updateState(String newState) //updating the state (e.g. if the state is changed to "rainy")
    {
        this.environmentState=newState;
        notifySensors();
    }

    private void notifySensors() //notifying the sensors about the state change (e.g. if the state is changed to "rainy", the sensors will be notified)
    {
        for (Sensor sensor : sensors) //for each sensor in the list of sensors
        {
            sensor.onStateChange(environmentState);
        }
    }




}