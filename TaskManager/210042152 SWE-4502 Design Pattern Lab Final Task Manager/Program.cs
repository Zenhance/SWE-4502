

using _210042152_SWE_4502_Design_Pattern_Lab_Final_Task_Manager;
using System.Threading.Channels;

class Program
{ 
    public static void Main(string[] args)
    {
        Issue i1 = new Issue(1,"new","content",2,"Subscription","Manager","Helpful","Better");
       UndoManager u1 = new UndoManager();
        Console.WriteLine(i1.getId());
        User u = new User("A");
        u.update("New content");
        u1.save(i1);
    }
}
