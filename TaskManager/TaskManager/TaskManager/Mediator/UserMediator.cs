namespace TaskManager.Model;

public class UserMediator
{
    public List<User> _users;

    public UserMediator()
    {
        _users = new List<User>();
    }

    public void AddUser(User user)
    {
        if (_users.Contains(user))
        {
            return;
        }
        
        _users.Add(user);
    }

    public void RemoveUser(User user)
    {
        _users.Remove(user);
    }

    public void NotifyUsers(string message)
    {
        foreach (User user in _users)
        {
            user.ReceiveEmail(message);
        }
    }
}