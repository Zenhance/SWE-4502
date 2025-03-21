import java.util.HashMap;
class IssueRepository {
    private static IssueRepository rep;
    private final HashMap<String, Issue> issues = new HashMap<String, Issue>();

    IssueRepository() {}

    public static IssueRepository getInstance() {
        if (rep == null) {
            rep = new IssueRepository();
        }
        return rep;
    }

    public void createIssue(Issue issue) {
        issues.put(issue.getId(), issue);
    }

    public Issue getIssue(String id) {
        return issues.get(id);
    }

    public void removeIssue(String id) {
        issues.remove(id);
    }

    public void showAllIssues() {
        issues.values().forEach(System.out::println);
    }

    public HashMap<String, Issue> getList() {
        return issues;
    }
}
