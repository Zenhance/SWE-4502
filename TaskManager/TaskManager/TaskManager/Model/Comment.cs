namespace TaskManager.Model;

public class Comment
{
    private int _id;
    private string _comment;
    private User _user;
    private DateTime _createdDate;
    
    public Comment(int id, string comment, User user, DateTime createdDate)
    {
        _id = id;
        _comment = comment;
        _user = user;
        _createdDate = createdDate;
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