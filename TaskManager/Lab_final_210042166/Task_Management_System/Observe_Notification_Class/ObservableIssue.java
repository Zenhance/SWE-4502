package Lab_final_210042166.Task_Management_System.Observe_Notification_Class;

import Lab_final_210042166.Task_Management_System.Enum.Priority;
import Lab_final_210042166.Task_Management_System.Enum.Status;
import Lab_final_210042166.Task_Management_System.Issue.Issue;
import Lab_final_210042166.Task_Management_System.Observer_Interface.NotifyObserver;

import java.util.ArrayList;
import java.util.List;


public class ObservableIssue extends Issue {
    private List<NotifyObserver> observers=new ArrayList<>();

    public ObservableIssue(String id, String title, String description ,Priority priority,String assignedTo)
    {
        super(id,title,description,priority,assignedTo);
    }

    public void addObserver(NotifyObserver observer)
    {
        observers.add(observer);
    }
    public void removeObserver(NotifyObserver observer)
    {
        observers.remove(observer);
    }

    public void sendNotification(String message)
    {
        for(NotifyObserver observer:observers)
        {
            observer.update(message);
        }
    }

    @Override
    public void setStatus(Status status){
      super.setStatus(status);
      sendNotification("Issue Status Changed to: " +status);
    }


}
