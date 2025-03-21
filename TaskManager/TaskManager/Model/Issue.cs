using TaskManager.ENUM;
using TaskManagerOriginal.ENUM;

namespace TaskManagerOriginal.Model;

public class Issue
{
    public int id;
    public string title;
    public string description;
    public PRIORITY priority;
    public STATUS status;
}