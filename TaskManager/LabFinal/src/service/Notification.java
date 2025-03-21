package service;
import java.time.LocalDateTime;

public class Notification
{
    private final NotificationType type;
    private final String message;
    private final String issueId;
    private final LocalDateTime timestamp;

    public Notification(NotificationType type, String message, String issueId) {
        this.type = type;
        this.message = message;
        this.issueId = issueId;
        this.timestamp = LocalDateTime.now();
    }

    public NotificationType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getIssueId() {
        return issueId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

}
