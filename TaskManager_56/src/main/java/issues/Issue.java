package issues;

import history.Memento;
import user.User;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Random;

public class Issue {
    public int id;
    public String title;
    public  String description;
public IssueRepository issueRepository;
    public enum Status{
        Open, InProgress, UnderReview, Resolved, Closed


    }
    public  enum Priority{
        Low,Medium,High,Critical
    };
    public Priority priority;


    public Status status;
    public Date creationDate;
    public Date LastModified;
    public String tag;

    Random rand = new Random();



    public Issue(){
        this.id= rand.nextInt(1000);
        this.status=Status.InProgress;




    }


    public void restore(Memento memento){


    }

//    public Memento save(){
//        return new Memento(new Issue(id,));
//
//    }






}
