package service;
import model.Comment;
import model.Issue;
import model.Status;
import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private final List<NotificationObserver> observers = new ArrayList<>();

    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    public void notifyIssueCreated(Issue issue) {
        String message = "New issue created: " + issue.getTitle();
        notifyObservers(new Notification(NotificationType.ISSUE_CREATED, message, issue.getId()));
    }

    public void notifyIssueUpdated(Issue issue) {
        String message = "Issue updated: " + issue.getTitle();
        notifyObservers(new Notification(NotificationType.ISSUE_UPDATED, message, issue.getId()));
    }

    public void notifyIssueDeleted(Issue issue) {
        String message = "Issue deleted: " + issue.getTitle();
        notifyObservers(new Notification(NotificationType.ISSUE_DELETED, message, issue.getId()));
    }

    public void notifyStatusChanged(Issue issue, Status oldStatus, Status newStatus) {
        String message = "Status changed for issue: " + issue.getTitle() +
                " from " + oldStatus + " to " + newStatus;
        notifyObservers(new Notification(NotificationType.STATUS_CHANGED, message, issue.getId()));
    }

    public void notifyCommentAdded(Issue issue, Comment comment) {
        String message = "Comment added to issue: " + issue.getTitle() +
                " by " + comment.getAuthor();
        notifyObservers(new Notification(NotificationType.COMMENT_ADDED, message, issue.getId()));
    }

    public void notifyCommentRemoved(Issue issue, Comment comment) {
        String message = "Comment removed from issue: " + issue.getTitle();
        notifyObservers(new Notification(NotificationType.COMMENT_REMOVED, message, issue.getId()));
    }

    private void notifyObservers(Notification notification) {
        for (NotificationObserver observer : observers) {
            observer.onNotification(notification);
        }
    }


}