import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueRepository{

    public Map<String, Issue> repository = new HashMap<>();
    public List<IObserver> obs = new ArrayList<>();



    public void registerIssue(Issue issue){
        repository.put(issue.getId(),issue);
    }

    public Issue getIssue(String id) {
        return repository.get(id);
    }

    public void removeIssue(String id){
        repository.remove(id);
    }

    public void updateIssue(Issue issue) {
        if (repository.containsKey(issue.getId())) {
            repository.put(issue.getId(), issue);
        }
    }

    public void addObserver(IObserver o){
        obs.add(o);
    }
    public void removeObserver(IObserver o){
        obs.remove(o);
    }
    private void notifyUsers(){
        for(IObserver ob: obs){
            ob.updateStatus();
        }
    }
}
