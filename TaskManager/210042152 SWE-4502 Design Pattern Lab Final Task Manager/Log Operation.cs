public class Logoperation
{
    private readonly List<Logoperation> lp = new List<Logoperation>();
    public void Add(Logoperation logoperation)
    {
        this.lp.Add(logoperation);
    }
    public void Remove(Logoperation logoperation)
    {
        this.lp.Remove(logoperation);
    }
    public void Show()
    {
        foreach (Logoperation logoperation in this.lp)
        {
            logoperation.Show();
        }
    }
}
