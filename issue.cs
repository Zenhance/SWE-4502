using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace taskManager
{
    public enum priority
    {
        Low,
        Medium,
        High,
        Crtitical
    }

    public enum status
    {
        Open,
        Inprogress,
        UnderReview,
        Resolved,
        Closed
    }
    public class issue : ICloneable
    {
        public int id;
        public string title;
        public string description;
        public enum priority { Low, Medium, High, Crtitical }
        public enum status { Open, Inprogress, UnderReview, Resolved, Closed }
        public DateTime creation_date;
        public DateTime last_modified_date;
        public string assignedto { get; set; }
        List<string> tags = new List<string> { };
        List<object> Icomments = new List<object> { };

        public issue(string title, string description, Enum priority)
        {
            this.title = title;
            this.description = description;
        }

        public object clone
        {
           issue clonedissue = new issue();

         

            
        }
    }
}
