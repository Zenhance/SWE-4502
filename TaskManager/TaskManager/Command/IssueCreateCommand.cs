﻿using TaskManager.Core;
using TaskManager.Log;
using TaskManager.Model;

namespace TaskManager.Command;

public class IssueCreateCommand : ICommand
{
    private IssueManager _issueManager;
    private Issue _issue;
    private IssuePrototype _issuePrototype;
    
    public IssueCreateCommand(IssueManager issueManager, Issue issue)
    {
        _issueManager = issueManager;
        _issue = issue;
        _issuePrototype = issue.Log();
    }

    public void execute()
    {
        _issueManager.AddIssue(_issue);
    }

    public void undo()
    {
        _issueManager.RemoveIssue(_issue);
    }

}