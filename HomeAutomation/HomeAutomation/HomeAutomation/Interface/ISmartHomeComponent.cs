using HomeAutomation.ENUM;
using HomeAutomation.Models;

namespace HomeAutomation.Interface;

public class ISmartHomeComponent
{
    void update(SENSOR sensor, Command command);
}