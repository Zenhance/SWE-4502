using TaskManager.Domain;

namespace TaskManager.Repositories;

public class CommentRepository
{
    private int _id = 0;
    private HashSet<Comment> _comments = new();

    public Comment Create(Comment comment)
    {
        _id++;
        comment.Id = _id;
        _comments.Add(comment);
        return comment;
    }

    public Comment? FindById(int id)
    {
        return _comments.Where(i => i.Id == id).First();
    }
}
