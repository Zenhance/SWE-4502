package com.taskmanager.service;

import com.taskmanager.model.Issue;
import com.taskmanager.model.Comment;
import com.taskmanager.model.Status;
import com.taskmanager.model.OperationLog;
import com.taskmanager.repository.IssueRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IssueService {
    private IssueRepository repository = new IssueRepository();
    private List<OperationLog> logs = new ArrayList<>();
    private NotificationService notificationService = new NotificationService();

    public void createIssue(Issue issue) {
        repository.addIssue(issue);
        logOperation("Created issue with ID: " + issue.getId(), "Create");
        notificationService.notify("Issue created: " + issue.getTitle());
    }

    public void updateIssue(Issue issue) {
        repository.updateIssue(issue);
        logOperation("Updated issue with ID: " + issue.getId(), "Update");
    }

    public void changeIssueStatus(String issueId, String status) {
        Issue issue = repository.getIssue(issueId);
        issue.setStatus(Status.valueOf(status));
        repository.updateIssue(issue);
        logOperation("Changed status of issue with ID: " + issueId + " to " + status, "Update");
        notificationService.notify("Issue status changed: " + issue.getTitle());
    }

    public void addComment(String issueId, Comment comment) {
        Issue issue = repository.getIssue(issueId);
        issue.getComments().add(comment);
        repository.updateIssue(issue);
        logOperation("Added comment to issue with ID: " + issueId, "Update");
    }

    private void logOperation(String description, String type) {
        logs.add(new OperationLog(description, new Date(), type));
    }}