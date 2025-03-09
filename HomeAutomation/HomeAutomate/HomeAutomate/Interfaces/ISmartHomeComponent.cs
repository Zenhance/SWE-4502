using HomeAutomate.Enum;

namespace HomeAutomate.Interfaces;

public interface ISmartHomeComponent
{
    void update(SENSOR sensor, float value);
}