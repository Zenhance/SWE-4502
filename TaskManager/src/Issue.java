public class Issue {
   public String ID;
   public String Title;
   public String Description;
   public String Status;
   public String Priority;
   public String CreationDate;
   public String LastModifiedDate;

   public String AssignedTo ;



   public Issue(String ID, String Title, String Description, String Status, String Priority, String CreationDate, String LastModifiedDate, String AssignedTo) {
       this.ID = ID;
       this.Title = Title;
       this.Description = Description;

       this.Status = Status;
       this.Priority = Priority;
       this.CreationDate = CreationDate;
       this.LastModifiedDate = LastModifiedDate;
       this.AssignedTo = AssignedTo;


   }


}

