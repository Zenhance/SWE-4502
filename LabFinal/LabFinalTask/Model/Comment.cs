namespace LabFinalTask.Model;

public class Comment
{
    public int id;
    public string content;
    public User createdBy;
    public DateTime createdDate;
    
    public Comment(string content, User createdBy)
    {
        this.content = content;
        this.createdBy = createdBy;
        this.createdDate = DateTime.Now;
    }
}