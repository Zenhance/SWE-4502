using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _210042152_SWE_4502_Design_Pattern_Lab_Final_Task_Manager
{
    public class Issue
    {
        public int id;
        public string title;
        public string description;
        public int priority;
        public string status;
        public DateTime creation;
        public DateTime modify;
        public string assign;
        public string tags;
        public string comments;
        public Issue(int id,string title,string description,int priority,string status,string assign,string tags,string comments)
        {
            this.id = id;
            this.title = title;
            this.description = description;
            this.priority = priority;
            this.assign = assign;
            this.tags = tags;
            this.comments = comments; 
            this.status = status;
        }
        public int getId()
        { 
            return id; 
        }
        public string getTitle()
        { 

            return title;
        }
        public string getDescription() 
        {
            return description;
        }
        public int getPriority() 
        {
            return priority;
        }
        public string getStatus() 
        { 
            return status;
        }
        public string getAssign()
        { 
            return assign; 
        }
        public string getTags()
        {
            return tags; 
        }
        public string getComments()
        { 
            return comments; 
        }

    }
}
