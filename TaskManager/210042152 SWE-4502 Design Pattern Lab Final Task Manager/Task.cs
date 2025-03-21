using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _210042152_SWE_4502_Design_Pattern_Lab_Final_Task_Manager
{
    public class Task
    {
        private readonly Stack<Task> _stack = new Stack<Task>();
        public Task()
        {
            
        }
        public void undo(Task task)
        {

            _stack.Pop();
        }
        public void redo(Task task)
        {
            _stack.Push(task);


        }
    }
    }
