package Lab_Final_210042150.Task_Management_System.Observer_Pattern;

import Lab_Final_210042150.Task_Management_System.Enums.Status;
import Lab_Final_210042150.Task_Management_System.Models.CommentModel.Comment;
import Lab_Final_210042150.Task_Management_System.Models.DomainModel.Issue;

public interface NotificationService {
    void notifyIssueCreated(Issue issue);
    void notifyIssueUpdated(Issue oldIssue, Issue newIssue);
    void registerObserver(NotificationObserver observer);
    void removeObserver(NotificationObserver observer);
    int getNotificationCount();
}

