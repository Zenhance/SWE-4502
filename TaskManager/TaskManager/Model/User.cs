namespace TaskManagerOriginal.Model;

public class User
{
    public string name;
    
    public User(string name)
    {
        this.name = name;
    }
    
    public void ReceiveNotification(string message)
    {
        Console.WriteLine("User " + name + " received notification: " + message);
    }
}