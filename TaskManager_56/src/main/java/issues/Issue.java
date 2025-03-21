package issues;

import javax.xml.crypto.Data;
import java.util.Date;

public class Issue {
    public int id;
    public String title;
    public  String description;
    public  String Priority;

    public Boolean status;
    public Date creationDate;
    public Date LastModified;
    public String tag;


    public Issue(int id){
        this.id=id;

    }

}
