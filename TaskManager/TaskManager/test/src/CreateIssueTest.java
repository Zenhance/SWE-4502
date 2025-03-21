import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateIssueTest{
    @Test
    void testIssueCreation(){
        IssueRepository issueRepository=new IssueRepository();
        Issue issue=new Issue("CreateTest","Testing the creation of issues",High);
        Command command=new CreateCommand(issueRepository);
        TaskManager taskManager=new TaskManager();
        taskManager.setCommand(command);
        taskManager.execution();
        int Id=1;


        assertEquals(True,taskManager.getDone());
    }
}