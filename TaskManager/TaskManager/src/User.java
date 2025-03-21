public class User implements Observer{
    String name;
    String emailAddress;
    String message;

    public void update(String message,String emailAddress){
         this.message=message;
         System.out.println(emailAddress+":"+message);
    }
}