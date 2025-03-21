using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TrelloApp
{
    public interface ICommand
    {
        public string description { get; set; }
        public int timestamp { get; set; }
        public CommandType type { get; set; }



        public void execute();
        public void undo();
    }
}
