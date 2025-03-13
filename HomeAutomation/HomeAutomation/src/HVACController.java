public class HVACController implements Observer
{
    private int targetTemperature;

    @Override
    public void update(EnvironmentState state)
    {
        this.targetTemperature = (int) state.getTemperature();
        if (targetTemperature > 25)
        {
            activateCooling();
        }
        else
        {
            activateHeating();
        }
    }

    @Override
    public void update(SystemState state)
    {
        this.targetTemperature = state.temperature;
        if (targetTemperature > 25)
        {
            activateCooling();
        }
        else
        {
            activateHeating();
        }
    }

    public void activateCooling()
    {
        System.out.println("Activating cooling system.");
    }

    public void activateHeating()
    {
        System.out.println("Activating heating system.");
    }
}
