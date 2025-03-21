namespace TaskManagerOriginal.Model;

public class Tag
{
    public string name;
    public int id;
    public string tagline;
    
    public Tag(string name, string tagline)
    {
        this.name = name;
        this.tagline = tagline;
    }
    
}