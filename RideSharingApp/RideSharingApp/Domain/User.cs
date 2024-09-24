namespace RideSharingApp;

public abstract class User
{
    public string Id = null!;
    public string Name = null!;
    public decimal Rating;

    protected User(string id, string name)
    {
        Id = id;
        Name = name;
    }

    public abstract decimal RecalculateRating(decimal updatedRating);
}