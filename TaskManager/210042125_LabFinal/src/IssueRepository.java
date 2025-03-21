import java.util.ArrayList;

public class IssueRepository {
    private ArrayList<Issue> IssueHistory;

    public IssueRepository(){
        IssueHistory= new ArrayList<>();
    }

    public void addIssue(Issue a){
        IssueHistory.add(a);
    }

    public void getIssueList(){
        for(Issue a: IssueHistory){
            System.out.println("Issue ID: "+ a.getID());
        }
    }
}
