using TaskManager.Domain;
using TaskManager.Service;

namespace TaskManager;

public class ConsoleUI
{
    private readonly IssueService _issueService;

    public ConsoleUI(IssueService issueService)
    {
        _issueService = issueService;
    }

    public void Run()
    {
        bool exit = false;
        while (!exit)
        {
            DisplayMenu();
            var choice = Console.ReadLine();
                
            switch (choice)
            {
                case "1":
                    CreateNewIssue();
                    break;
                case "2":
                    ViewAllIssues();
                    break;
                case "3":
                    AddCommentToIssue();
                    break;
                case "4":
                    ChangeIssueStatus();
                    break;
                case "5":
                    _issueService.UndoLastCommand();
                    Console.WriteLine("Last command undone.");
                    break;
                case "6":
                    _issueService.RedoCommand();
                    Console.WriteLine("Command redone.");
                    break;
                case "7":
                    ViewCommandHistory();
                    break;
                case "8":
                    exit = true;
                    break;
            }
        }
    }

    private void DisplayMenu()
    {
        Console.WriteLine("\n=== Issue Tracker Menu ===");
        Console.WriteLine("1. Create new issue");
        Console.WriteLine("2. View all issues");
        Console.WriteLine("3. Add comment to issue");
        Console.WriteLine("4. Change issue status");
        Console.WriteLine("5. Undo last action");
        Console.WriteLine("6. Redo action");
        Console.WriteLine("7. View command history");
        Console.WriteLine("8. Exit");
        Console.Write("Enter choice: ");
    }

    private void CreateNewIssue()
    {
        Console.Write("Title: ");
        var title = Console.ReadLine();
            
        Console.Write("Description: ");
        var description = Console.ReadLine();
            
        Console.WriteLine("Priority (0: Low, 1: Medium, 2: High, 3: Critical): ");
        var priorityInput = Console.ReadLine();
        if (!Enum.TryParse(priorityInput, out IssuePriority priority))
            priority = IssuePriority.Medium;
            
        Console.Write("Assigned to (leave blank for unassigned): ");
        var assignedTo = Console.ReadLine();
        if (string.IsNullOrWhiteSpace(assignedTo))
            assignedTo = null;
            
        int id = _issueService.CreateIssue(title, description, priority, assignedTo);
        Console.WriteLine($"Issue created with ID: {id}");
    }

    private void ViewAllIssues()
    {
        var issues = _issueService.GetAllIssues();
            
        Console.WriteLine("\n=== All Issues ===");
        foreach (var issue in issues)
        {
            Console.WriteLine($"ID: {issue.Id} | {issue.Title} | Status: {issue.Status} | Priority: {issue.Priority}");
        }
    }

    private void AddCommentToIssue()
    {
        Console.Write("Issue ID: ");
        if (int.TryParse(Console.ReadLine(), out int id))
        {
            var issue = _issueService.GetIssue(id);
            if (issue == null)
            {
                Console.WriteLine("Issue not found.");
                return;
            }
                
            Console.WriteLine($"Adding comment to: {issue.Title}");
            Console.Write("Comment: ");
            var content = Console.ReadLine();
                
            Console.Write("Author: ");
            var author = Console.ReadLine();
                
            _issueService.AddComment(id, content, author);
            Console.WriteLine("Comment added successfully.");
        }
        else
        {
            Console.WriteLine("Invalid ID format.");
        }
    }

    private void ChangeIssueStatus()
    {
        Console.Write("Issue ID: ");
        if (int.TryParse(Console.ReadLine(), out int id))
        {
            var issue = _issueService.GetIssue(id);
            if (issue == null)
            {
                Console.WriteLine("Issue not found.");
                return;
            }
                
            Console.WriteLine($"Current status of '{issue.Title}': {issue.Status}");
            Console.WriteLine("New status (0: Open, 1: InProgress, 2: UnderReview, 3: Resolved, 4: Closed): ");
                
            if (Enum.TryParse(Console.ReadLine(), out IssueStatus status))
            {
                _issueService.ChangeStatus(id, status);
                Console.WriteLine($"Status changed to {status}.");
            }
            else
            {
                Console.WriteLine("Invalid status value.");
            }
        }
        else
        {
            Console.WriteLine("Invalid ID format.");
        }
    }

    private void ViewCommandHistory()
    {
        var history = _issueService.GetCommandHistory();
            
        Console.WriteLine("\n=== Command History ===");
        foreach (var command in history)
        {
            Console.WriteLine($"[{command.Timestamp}] {command.Description}");
        }
    }
}