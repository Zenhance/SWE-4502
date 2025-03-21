package services;

import models.Issue;
import models.IssueRepository;
import patterns.IssueMediator;

public class TaskManager {
    private IssueRepository repository;
    private IssueMediator mediator;

    public TaskManager() {
        this.repository = new IssueRepository();
        this.mediator = new IssueMediator();
    }

    public void createIssue(int id, String title, String description, String priority) {
        Issue issue = new Issue(id, title, description, priority);
        repository.addIssue(issue);
        mediator.notifyObservers("Issue Created: " + title);
    }

    public void changeStatus(int id, String newStatus) {
        Issue issue = repository.getIssue(id);
        if (issue != null) {
            issue.setStatus(newStatus);
            mediator.notifyObservers("Status changed to: " + newStatus);
        }
    }
}