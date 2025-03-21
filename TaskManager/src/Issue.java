import java.util.ArrayList;
import java.util.List;

class Issue {
   public String ID;
   public String Title;
   public String Description;
   public String Status;
   public String Priority;
   public String CreationDate;
   public String LastModifiedDate;

   public String AssignedTo ;

   private List<IssueObserver> observers = new ArrayList<>();

   public Issue(String ID, String Title, String Description, String Status, String Priority, String CreationDate, String LastModifiedDate, String AssignedTo) {
       this.ID = ID;
       this.Title = Title;
       this.Description = Description;

       this.Status = "Created";
       this.Priority = Priority;
       this.CreationDate = CreationDate;
       this.LastModifiedDate = LastModifiedDate;
       this.AssignedTo = AssignedTo;

   }
    public void create(IssueObserver observer) {
        observers.add(observer);
    }


    public void notifyObservers() {

       for (IssueObserver observer : observers) {

       }
    }


    public void setStatus(String status) {
       this.Status = status;
       notifyObservers();
    }


    public void setPriority(String priority) {
       this.Priority = priority;
       notifyObservers();
    }

    public void setAssignedTo(String assignedTo) {
       this.AssignedTo = assignedTo;
       notifyObservers();
    }

    public String getStatus(){
       return this.Status;
    }
  public String getAssignedTo(){
       return this.AssignedTo;
  }

}

