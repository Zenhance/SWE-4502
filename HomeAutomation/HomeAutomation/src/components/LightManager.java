package components;
import core.Sensor;

public class LightManager implements Sensor
{
    @Override
    public void onStateChange(String newState) //Responds to changes in ambient light levels
    {
        if (newState.contains("dark")) {
            System.out.println("It's dark. Turning on lights.");
        }
        if(newState.contains("bright"))
        {
            System.out.println("It's bright. Turning off lights.");
        }
    }

    //Adjusts lighting based on room occupancy
    public void adjustLighting(boolean occupied)
    {
        if(occupied)
        {
            System.out.println("Room is occupied. Turning on lights.");
        }
        else
        {
            System.out.println("Room is unoccupied. Turning off lights.");
        }
    }

    //Supports different "scenes" for various activities (reading, movie watching, etc.)
    public void setScene(String scene)
    {
        switch(scene)
        {
            case "reading":
                System.out.println("Setting lighting for reading.");
                break;
            case "movie":
                System.out.println("Setting lighting for movie watching.");
                break;
            case "relaxing":
                System.out.println("Setting lighting for relaxing.");
                break;
            default:
                System.out.println("Scene not recognized.");
        }
    }







}
