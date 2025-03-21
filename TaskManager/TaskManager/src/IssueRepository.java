import java.util.*;
public class IssueRepository{
    public int Id;
    HashMap<int,Issue>issues=new HashMap<>();

    public void create(int Id, Issue issue){
        issues.put(Id,issue);
        creation=true;
    }
}