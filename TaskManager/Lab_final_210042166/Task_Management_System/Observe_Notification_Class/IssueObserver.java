package Lab_final_210042166.Task_Management_System.Observe_Notification_Class;

import Lab_final_210042166.Task_Management_System.Observer_Interface.NotifyObserver;

public class IssueObserver implements NotifyObserver {
 private String observerName;

 public IssueObserver(String observerName)
 {
     this.observerName=observerName;
 }

 @Override
    public void update(String message)
 {
     System.out.println(observerName + "Received Notification" + message);
 }
}
