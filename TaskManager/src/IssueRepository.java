import java.util.HashMap;
class IssueRepository {
    private static IssueRepository rep;
    private final HashMap<Integer, Issue> issues = new HashMap<>();

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

    public Issue getIssue(Integer id) {
        return issues.get(id);
    }

    public void removeIssue(Integer id) {
        issues.remove(id);
    }

    public void showAllIssues() {
        issues.values().forEach(System.out::println);
    }

    public HashMap<Integer, Issue> getList() {
        return issues;
    }
}
