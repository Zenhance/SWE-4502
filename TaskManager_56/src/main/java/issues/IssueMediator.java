package issues;

public interface IssueMediator {
    enum Status{
        Open, InProgress, UnderReview, Resolved, Closed


    }
    void addIssue(Issue issue);
    void changeStatus(Status status,Issue issue);
}
