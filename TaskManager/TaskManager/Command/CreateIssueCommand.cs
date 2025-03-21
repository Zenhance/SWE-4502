﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    public class CreateIssueCommand
    {
        private IssueRepository _repo;
        private Issue _Issue;

        public void Execute()
        {
            _repo.AddIssue(_Issue);
        }

        public void Undo()
        {
            _repo.AddIssue(_Issue);
        }
    }
}
