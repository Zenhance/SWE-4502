namespace TaskManager.Model;

public class User
{
    public void ReceiveEmail(string message)
    {
        Console.WriteLine("Email received: " + message);
    }
}