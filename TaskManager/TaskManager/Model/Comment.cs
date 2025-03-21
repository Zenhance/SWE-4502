namespace TaskManagerOriginal.Model;

public class Comment
{
    public int id;
    public string text;
    public DateTime createdDate;
    public User createdBy;
    
    public Comment(string text, User createdBy)
    {
        this.text = text;
        this.createdBy = createdBy;
        this.createdDate = DateTime.Now;
    }
    
    
}