using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace TaskManager_210042112
{
    public class Issue
    {
        public int Id { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        
        public DateTime CreationDate { get; set; }
        public DateTime LastModifiedDate { get; set; }
        public string AssignedTo { get; set; }
        

        public Issue(int id, string title, string description)
        {
            Id = id;
            Title = title;
            Description = description;
           
            CreationDate = DateTime.Now;
            LastModifiedDate = DateTime.Now;
       
            
        }
    }
}
