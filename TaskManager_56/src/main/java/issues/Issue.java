package issues;

import javax.xml.crypto.Data;
import java.util.Date;

public class Issue {
    public int id;
    public String title;
    public  String description;
    public  enum Priority{
        Low,Medium,High,Critical
    };

    public enum status{
        Open, InProgress, UnderReview, Resolved, Closed
    };
    public Date creationDate;
    public Date LastModified;
    public String tag;


    public Issue(int id){
        this.id=id;

    }


    public void create(){
        
    }

}
