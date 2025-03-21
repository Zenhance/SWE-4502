using TaskManagerOriginal.Model;

namespace TaskManagerOriginal;

public class Mediate
{
    public List<User> users;
    
    public Mediate()
    {
        users = new List<User>();
    }
    
    public void AddUser(User user)
    {
        users.Add(user);
    }
    
    public void NotifyUsers(string message)
    {
        foreach (User user in users)
        {
            user.ReceiveNotification(message);
        }
    }
    
    public void removeUser(User user)
    {
        users.Remove(user);
    }
}