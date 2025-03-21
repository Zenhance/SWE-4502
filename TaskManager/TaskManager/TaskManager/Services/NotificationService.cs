using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using global::TaskManager.Models.TaskManager.Models;
using global::TaskManager.Models;
using System;

namespace TaskManager.Services
{
        public class NotificationService
        {
            public void NotifyIssueCreated(Issue issue)
            {
                Console.WriteLine($"Notification: New issue created - {issue.Title}");
                Console.WriteLine($"Assigned to: {issue.AssignedTo}");
                Console.WriteLine($"Priority: {issue.Priority}");
            }

            public void NotifyStatusChanged(Issue issue, string oldStatus)
            {
                Console.WriteLine($"Notification: Issue status changed - {issue.Title}");
                Console.WriteLine($"Status changed from {oldStatus} to {issue.Status}");
                Console.WriteLine($"Assigned to: {issue.AssignedTo}");
            }

            public void NotifyCommentAdded(Issue issue, Comment comment)
            {
                Console.WriteLine($"Notification: New comment added to issue - {issue.Title}");
                Console.WriteLine($"Comment by: {comment.Author}");
                Console.WriteLine($"Content: {comment.Content}");
            }
        }
}