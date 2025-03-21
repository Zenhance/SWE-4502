import org.junit.Assert;
import org.junit.Test;

public class ____TestCommandManagerTest {
    public User user = new User("Adid");
    public Issue issue = new Issue("101","Issue 1" , PRIORITY.High, STATUS.Open, user);
    public IssueRepository repository= new IssueRepository(issue);
    CreateCommand create =new CreateCommand(repository,issue);
    UpdateCommand update = new UpdateCommand(issue, "Updated Title", PRIORITY.Low);
    Comment comment1 = new Comment("C1", "Comment", user);
    UpdateCommand addComment = new UpdateCommand(issue, comment1);
    ChangeCommand change = new ChangeCommand(issue, STATUS.Closed);
    CommandManager manager = new CommandManager();

    // Test Issue Creation
    @Test
    public void IssueCreationTest(){
        manager.setCommand(create);
        Issue newIssue = manager.executeCommand();
        Assert.assertEquals("101", newIssue.getId());
    }

    // Test Issue Update
    @Test
    public void IssueUpdateTest(){
        manager.setCommand(update);
        Issue newIssue = manager.executeCommand();
        Assert.assertEquals("Updated Title", newIssue.getTitle());
    }

    // Test Issue Status
    @Test
    public void IssueStatusTest(){
        manager.setCommand(change);
        Issue newIssue = manager.executeCommand();
        Assert.assertEquals(STATUS.Closed, newIssue.getStatus());
    }

    // Add comment Test
    @Test
    public void IssueCommentTest(){
        manager.setCommand(addComment);
        Issue newIssue = manager.executeCommand();
        Assert.assertEquals("Comment", newIssue.getComments().getLast().getContent());
    }
}