//User Mediator
using TaskManager.Model;

namespace TaskManager.Mediator;

public class UserMediator
{
    public List<User> users;
    
    public UserMediator()
    {
        users = new List<User>();
    }
    
    public void AddUser(User user)
    {
        if(users.Contains(user))
        {
            return;
        }
        
        users.Add(user);
    }
    
    public void RemoveUser(User user)
    {
        users.Remove(user);
    }
    
    public void NotifyUsers(string message)
    {
        foreach (User user in users)
        {
            user.ReceiveEmail(message);
        }
    }
}