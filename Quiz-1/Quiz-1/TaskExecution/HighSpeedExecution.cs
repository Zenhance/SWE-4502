namespace Quiz_1.TaskExecution;


public class HighSpeedExecution : ITaskExecutionStrategy
{
    public string ExecuteTask()
    {
        return "Executing task at high speed!";
    }
}