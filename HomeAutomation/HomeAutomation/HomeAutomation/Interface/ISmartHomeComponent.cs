using HomeAutomation.ENUM;
using HomeAutomation.Models;

namespace HomeAutomation.Interface;

public interface ISmartHomeComponent
{
    void update(SENSOR sensor, Command command);
}