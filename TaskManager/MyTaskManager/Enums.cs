using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyTaskManager
{
    public enum Priority { Low, Medium, High, Critical }
    public enum Status { Open, InProgress, UnderReview, Resolved, Closed }
    public enum CommandType { Create, Update, Delete }
}
