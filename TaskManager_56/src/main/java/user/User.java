package user;

import comment.Comment;
import issues.Issue;
import issues.IssueRepository;

import java.util.HashMap;

public class User {
    public HashMap<Integer,Issue> issueRepository = new HashMap<>();
    public Integer id;
    public String name;

    public User(Integer id,String name){
        this.id=id;
        this.name=name;
    }

    public  Issue createIssue(String title,String description){
        Issue issue = new Issue();
        issue.title=title;
        issue.description=description;
        issue.status= Issue.Status.InProgress;
        this.issueRepository.put(issue.id,issue);

        return issue;


    }
    public Comment createComment(Integer id,String description,Integer issueId,Integer authorId){
        Issue issue= issueRepository.get(issueId);
        Comment comment= new Comment(id,description,authorId);
        issue.commentHashMap.put(id,comment);


        return comment;

    }
    public void updateIssueState(Issue.Status status,Issue issue){
        issue.status=status;

    }






}
