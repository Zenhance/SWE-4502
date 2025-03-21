package history;

import issues.Issue;

public class Memento {
    private Issue issue;

    public Memento(Issue issue){
        this.issue= issue;
    }
    public Issue getIssue(){
        return  this.issue;
    }
}
