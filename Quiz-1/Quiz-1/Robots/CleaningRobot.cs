using Quiz_1.TaskExecution;

namespace Quiz_1.Robots;

public class CleaningRobot : Robot
{
    public CleaningRobot(ITaskExecutionStrategy taskExecutionStrategy)
        : base(taskExecutionStrategy) { }

    protected override void InitializeRobot()
    {
        Console.WriteLine("Initializing Cleaning Robot...");
    }

    protected override void MoveToLocation()
    {
        Console.WriteLine("Moving Cleaning Robot to cleaning area...");
    }

    protected override void ShutdownRobot()
    {
        Console.WriteLine("Shutting down Cleaning Robot...");
    }
}