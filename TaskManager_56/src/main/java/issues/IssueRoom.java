package issues;

import java.util.ArrayList;
import java.util.List;

public class IssueRoom implements IssueMediator{
    private List<Issue> issues = new ArrayList<>();
    @Override
    public void addIssue(Issue issue) {
        issues.add((issue));


    }

    @Override
    public void changeStatus(Status status,Issue issue) {



    }
}
