using MyTaskManager;
using System;
using System.Threading.Tasks;

namespace MyTaskManger
{
    class Program
    {
        static void Main(string[] args)
        {
            Comment comment = new Comment(1, "Hello", "John");
            Comment clone = (Comment)comment.Clone();
            Console.WriteLine(comment.CreatedAt);
            Console.WriteLine(clone.CreatedAt);
        }
    }
}
