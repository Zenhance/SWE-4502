import org.junit.Before;
import org.junit.Test;

public class CreateIssueTest {

    private IssueRepository repository;


    public comment comment;




    @Test
    public void createIssueTest(){
        Issue issue = new Issue(1, "titl1", "description1", "HIGH", "CLOSED","2007-12-03T10:15:30", "2007-12-03T10:15:30", "Sani", "tag2", comment);
        repository.addIssue(issue);

        Issue retrievedIssue = repository.getIssue(1);




    }



}
