import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.platform.commons.util.Preconditions.notNull;

public class AddCommentTest {
    private IssueRepository repository;
    private Command c1;
    private Command c2;
    private  Comment c;
    public Issue i;



    @BeforeEach
    void setUp() {
        repository = new IssueRepository();
        c1 = new CreateIssue(repository, " Bug Fix", "Dashboard", Priority.Low);
        c= new Comment(1,"hello","naf");


    }

    @Test
    void tesComment() {


        c1.execute();
        i=repository.getIssue( 1);
        c2=new AddComments(i,c);


        Issue issue = repository.getIssue(1);



        assert.notNull(i.commentList);
    }

}
