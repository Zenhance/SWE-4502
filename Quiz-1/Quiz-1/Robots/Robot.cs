using Quiz_1.TaskExecution;

namespace Quiz_1.Robots;

// Abstract class: RobotTask (Template Method)
public abstract class Robot
{
    public ITaskExecutionStrategy TaskExecutionStrategy;

    protected Robot(ITaskExecutionStrategy taskExecutionStrategy)
    {
        TaskExecutionStrategy = taskExecutionStrategy;
    }

    // Template Method defining the workflow
    public void ProcessTask()
    {
        InitializeRobot();
        MoveToLocation();
        PerformTask();  // Delegating task execution to the strategy
        ShutdownRobot();
    }

    protected abstract void InitializeRobot();
    protected abstract void MoveToLocation();
    protected abstract void ShutdownRobot();

    // Task execution step, delegated to strategy
    private void PerformTask()
    {
        string result = TaskExecutionStrategy.ExecuteTask();
        Console.WriteLine(result);
    }
}