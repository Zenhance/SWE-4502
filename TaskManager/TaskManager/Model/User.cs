namespace TaskManager.Model;

public class User
{
    public string name;
    public string lastEmail;
    
    public User(string name)
    {
        this.name = name;
        this.lastEmail = "";
    }
    
    public void ReceiveEmail(string message)
    {
        this.lastEmail = message;
    }
    
    
}