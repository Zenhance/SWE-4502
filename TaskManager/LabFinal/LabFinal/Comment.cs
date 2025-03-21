
namespace LabFinal;
public class Comment
{
    public int Id { get; set; }
    public string Content { get; set; }
    public string Author { get; set; }
    public DateTime CreatedAt { get; set; }

    public Comment(int id, string content, string author)
    {
        Id = id;
        Content = content;
        Author = author;
        CreatedAt = DateTime.Now;
    }
}
