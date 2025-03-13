using HomeAutomate.Enum;
using HomeAutomate.Models;

namespace HomeAutomate.Interfaces;

public interface ISmartHomeComponent
{
    void update(SENSOR sensor, Command command);
}