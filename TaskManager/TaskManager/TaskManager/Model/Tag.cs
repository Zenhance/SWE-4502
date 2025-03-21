namespace TaskManager.Model;

public class Tag
{
    private string _name;
    private string _description;
    private int _id;
    
    public Tag(string name, string description, int id)
    {
        _name = name;
        _description = description;
    }
}