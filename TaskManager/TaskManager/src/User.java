public class User implements Observer{
    String name;
    String emailAddress;

    public void update(String message,String emailAddress){
         this.message=message;
         System.out.println(emailAddress+":"+message);
    }
}