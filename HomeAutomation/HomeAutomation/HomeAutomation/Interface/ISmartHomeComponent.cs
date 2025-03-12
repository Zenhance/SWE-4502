using HomeAutomation.Enum;
using HomeAutomation.Model;

namespace HomeAutomation.Interface;

public interface ISmartHomeComponent
{
    void update(SENSOR sensor, Command command);
}