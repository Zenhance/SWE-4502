namespace TaskManager.Model;

public class Comment
{
    private int _id;
    private string _comment;
    private User _user;
    private DateTime _createdDate;
    
    public Comment(string comment, User user)
    {
        _comment = comment;
        _user = user;
        _createdDate = DateTime.Now;
    }
    
    public int getId()
    {
        return _id;
    }

    public string getComment()
    {
        return _comment;
    }
    
    public User getUser()
    {
        return _user;
    }
    
    public DateTime getCreatedDate()
    {
        return _createdDate;
    }
}