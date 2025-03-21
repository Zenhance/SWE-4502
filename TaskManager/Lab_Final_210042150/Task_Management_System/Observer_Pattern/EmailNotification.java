package Lab_Final_210042150.Task_Management_System.Observer_Pattern;
import Lab_Final_210042150.Task_Management_System.Enums.Status;
import Lab_Final_210042150.Task_Management_System.Models.CommentModel.Comment;
import Lab_Final_210042150.Task_Management_System.Models.DomainModel.Issue;

import java.util.*;

public class EmailNotification implements NotificationService {
    private final List<NotificationObserver> observers = new ArrayList<>();
    private int notificationCount = 0;

    @Override
    public void notifyIssueCreated(Issue issue) {
        System.out.println("Sending email notification: Issue created - " + issue.getTitle());
        notificationCount++;
        for (NotificationObserver observer : new ArrayList<>(observers)) {
            observer.onIssueCreated(issue);
        }
    }

    @Override
    public void notifyIssueUpdated(Issue oldIssue, Issue newIssue) {
        System.out.println("Sending email notification: Issue updated - " + newIssue.getTitle());
        notificationCount++;
        for (NotificationObserver observer : new ArrayList<>(observers)) {
            observer.onIssueUpdated(oldIssue, newIssue);
        }
    }

    @Override
    public void notifyIssueDeleted(Issue issue) {
        System.out.println("Sending email notification: Issue deleted - " + issue.getTitle());
        notificationCount++;
        for (NotificationObserver observer : new ArrayList<>(observers)) {
            observer.onIssueDeleted(issue);
        }
    }

    @Override
    public void notifyStatusChanged(Issue issue, Status oldStatus, Status newStatus) {
        System.out.println("Sending email notification: Issue status changed from " +
                oldStatus + " to " + newStatus + " - " + issue.getTitle());
        notificationCount++;
        for (NotificationObserver observer : new ArrayList<>(observers)) {
            observer.onStatusChanged(issue, oldStatus, newStatus);
        }
    }

    @Override
    public void notifyCommentAdded(Issue issue, Comment comment) {
        System.out.println("Sending email notification: Comment added to issue - " + issue.getTitle());
        notificationCount++;
        for (NotificationObserver observer : new ArrayList<>(observers)) {
            observer.onCommentAdded(issue, comment);
        }
    }

    @Override
    public void notifyCommentRemoved(Issue issue, Comment comment) {
        System.out.println("Sending email notification: Comment removed from issue - " + issue.getTitle());
        notificationCount++;
        for (NotificationObserver observer : new ArrayList<>(observers)) {
            observer.onCommentRemoved(issue, comment);
        }
    }

    @Override
    public void registerObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    @Override
    public int getNotificationCount() {
        return notificationCount;
    }
}
