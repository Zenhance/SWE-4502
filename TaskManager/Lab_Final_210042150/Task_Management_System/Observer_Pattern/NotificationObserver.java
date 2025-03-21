package Lab_Final_210042150.Task_Management_System.Observer_Pattern;

import Lab_Final_210042150.Task_Management_System.Enums.Status;
import Lab_Final_210042150.Task_Management_System.Models.CommentModel.Comment;
import Lab_Final_210042150.Task_Management_System.Models.DomainModel.Issue;

public interface NotificationObserver {
    void onIssueCreated(Issue issue);
    void onIssueUpdated(Issue oldIssue, Issue newIssue);
    void onIssueDeleted(Issue issue);
    void onStatusChanged(Issue issue, Status oldStatus, Status newStatus);
    void onCommentAdded(Issue issue, Comment comment);
    void onCommentRemoved(Issue issue, Comment comment);
}

