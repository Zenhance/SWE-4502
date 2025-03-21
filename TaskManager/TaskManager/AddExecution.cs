using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    public class AddExecution:ICommand
    {
        public string Name { get; set; }
        public Issue Issue { get; set; }

        public AddExecution(string Name, Issue Issue)
        {
            this.Name = Name;
            this.Issue = Issue;
        }

        public void Execute()
        {
           Issue.ExecuteCommand.Add();
        }

        public void Undo()
        {
            Issue.Executions.Remove(Name);
        }
    }
}
