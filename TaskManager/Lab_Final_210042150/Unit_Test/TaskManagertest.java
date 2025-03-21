package Lab_Final_210042150.Unit_Test;

import Lab_Final_210042150.Task_Management_System.Repositories.IssueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskManagertest {
    private IssueRepository repository;

    @BeforeEach
    public void setup()
    {
        repository = new IssueRepository();
    }

    @Test
    public void createIssue_ShouldAddIssueToRepository()
    {

    }
}
