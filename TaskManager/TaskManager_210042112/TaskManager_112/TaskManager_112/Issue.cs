using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager_112
{
    public class Issue
    {
        public int ID { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public string Priority { get; set; }
        public string Status { get; set; }
        public DateTime CreationDate { get; set; }
        public DateTime LastModifiedDate { get; set; }
        public string AssignedTo { get; set; }
        public List<string> Tags { get; set; } //cause tags can be multiple
        public List<string> Comments { get; set; } //cause comments can be multiple
        public Issue(int id,string title, string description, List<string> tags)
        {
            ID = id;
            Title = title;
            Description = description;
            CreationDate = DateTime.Now;
            LastModifiedDate = DateTime.Now;
            Tags = tags.ToList();    
            Comments = new List<string>();

        }

    }
}
