public class LightController implements Observer
{
    int lightLevel;

    @Override
    public void update(EnvironmentState state)
    {
        this.lightLevel = (int) state.getLightLevel();
        if (lightLevel < 50)
        {
            turnOnLights();
        }
        else
        {
            turnOffLights();
        }
    }

    @Override
    public void update(SystemState state)
    {
        this.lightLevel = state.lightLevel;
        if (lightLevel < 50)
        {
            turnOnLights();
        }
        else
        {
            turnOffLights();
        }
    }

    public void turnOnLights()
    {
        System.out.println("Turning on the lights.");
    }

    public void turnOffLights()
    {
        System.out.println("Turning off the lights.");
    }
}
