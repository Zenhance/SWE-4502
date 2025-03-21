namespace LabFinalTask.Model;

public class User
{
    public string name;
    
    public User(string name)
    {
        this.name = name;
    }
    
    public void ReceiveEmail(string message)
    {
        Console.WriteLine($"{name} received email: {message}");
    }
    
    
}