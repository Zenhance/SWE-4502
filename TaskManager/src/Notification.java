import java.util.ArrayList;
import java.util.List;

public class Notification implements IssueObserver{


    public void update(String message) {
        System.out.println("Notification: " + message);
    }


}


