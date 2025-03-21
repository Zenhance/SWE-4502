package Lab_Final_210042150.Task_Management_System.Observer_Pattern;

import Lab_Final_210042150.Task_Management_System.Models.DomainModel.Issue;

public interface NotificationObserver {
    void onIssueCreated(Issue issue);

    void onIssueUpdated(Issue oldIssue, Issue newIssue);
}

