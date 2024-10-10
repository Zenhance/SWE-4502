using Quiz_1.TaskExecution;

namespace Quiz_1.Robots;

public class RepairRobot : Robot
{
    public RepairRobot(ITaskExecutionStrategy taskExecutionStrategy)
        : base(taskExecutionStrategy) { }

    protected override void InitializeRobot()
    {
        Console.WriteLine("Initializing Repair Robot...");
    }

    protected override void MoveToLocation()
    {
        Console.WriteLine("Moving Repair Robot to repair site...");
    }

    protected override void ShutdownRobot()
    {
        Console.WriteLine("Shutting down Repair Robot...");
    }
}