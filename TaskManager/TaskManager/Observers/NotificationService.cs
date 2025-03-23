using TaskManager.Commands;

namespace TaskManager.Observers;

public class NotificationService : IObserver
{
    public void Update(ICommand command)
    {
        if (command is CreateIssueCommand)
        {
            Console.WriteLine($"NOTIFICATION: New issue created at {command.Timestamp}");
        }
        else if (command is ChangeIssueStatusCommand)
        {
            Console.WriteLine($"NOTIFICATION: Issue status changed at {command.Timestamp}");
        }
    }

    public void SendEmail(string recipient, string subject, string body)
    {
        // Simulate sending email
        Console.WriteLine($"Email sent to {recipient}: {subject}");
    }
}