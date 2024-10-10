using Quiz_1.Robots;

namespace Quiz_1.TaskExecution;

public class TaskExecutionContext
{
    private readonly Robot _processor;

    public TaskExecutionContext(Robot processor)
    {
        _processor = processor;
    }

    public void SetStrategy(ITaskExecutionStrategy strategy)
    {
        _processor.TaskExecutionStrategy = strategy;
    }

    public void Execute()
    {
        _processor.ProcessTask();
    }
}