﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace labfinal_210042111
{
    public class Issue
    {
        public int Id { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public Priority priority { get; set; }
        public Status status { get; set; }
        public DateTime CreationDare { get; set; }
        public DateTime LastModificationDate { get; set; }
        public string AssignTo { get; set; }
        public List<string> Tags { get; set; }=new List<string>();
        public List<string> Comments { get; set; } = new List<string>();


        public Issue() { }
    }
}
