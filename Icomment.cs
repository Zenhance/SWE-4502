using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace taskManager
{
        public interface Icomment
        {
            int id { get; set; }
            string content { get; set; }
            string author { get; set; }
            string createdAt { get; set; }

        }
}
