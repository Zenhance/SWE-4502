import org.junit.Test;
import org.junit.Assert;


public class CreateIssue_ShouldAddIssueToRepository {
    public User user = new User("Adid");
    public Issue issue = new Issue("101","Issue 1" , PRIORITY.High, STATUS.Open, user);
    public IssueRepository repository= new IssueRepository(issue);
    @Test

    public void objectCreationTest(){
        Issue newIssue = repository.createIssue();
        Assert.assertEquals("101", newIssue.getId());
    }

}