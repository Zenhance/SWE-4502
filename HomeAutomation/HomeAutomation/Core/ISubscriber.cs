namespace HomeAutomation.Core;

public interface ISubscriber
{
    string Update(State state);
}
