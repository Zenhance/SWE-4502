using HomeAutomate.Enum;

namespace HomeAutomate.Factory;

public class TemperatureFactory
{
    public static TEMPSTATE GetState(float outsideTemperature)
    {
        if(outsideTemperature < 15)
        {
            return TEMPSTATE.HEATING;
        }
        else if(outsideTemperature > 30)
        {
            return TEMPSTATE.COOLING;
        }
        else
        {
            return TEMPSTATE.IDLE;
        }
    }
    
    public static int GetTemperature(float outsideTemperature)
    {
        if(outsideTemperature < 15)
        {
            return 25;
        }
        else if(outsideTemperature > 30)
        {
            return 20;
        }
        else
        {
            return 22;
        }
    }
}