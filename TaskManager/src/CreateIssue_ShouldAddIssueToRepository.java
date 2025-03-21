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

    @Test
    public void objectCreationTest2(){
        Issue newIssue = repository.createIssue();
        Assert.assertEquals("Issue 1", newIssue.getTitle());
    }
    @Test
    public void objectCreationTest3(){
        Issue newIssue = repository.createIssue();
        Assert.assertEquals(PRIORITY.High, newIssue.getPriority());
    }
    @Test
    public void objectCreationTest4(){
        Issue newIssue = repository.createIssue();
        Assert.assertEquals(STATUS.Open, newIssue.getStatus());
    }
}