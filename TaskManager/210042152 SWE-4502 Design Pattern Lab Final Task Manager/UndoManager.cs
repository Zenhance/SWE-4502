using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _210042152_SWE_4502_Design_Pattern_Lab_Final_Task_Manager
{
   public class UndoManager
    {
        private readonly Stack<Issue> _issues = new Stack<Issue>();
        public void save(Issue issue)
        {

        _issues.Push(issue); 
        }
        public void undo()
        {
            _issues.Pop();
        }
    }
    }

