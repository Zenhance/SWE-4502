public class Informer implements Subject{
    private List<User>users=new ArrayList<>();
    public String message;
    public String emailAddress;
    public boolean done=false;

    public void addUser(){
        users.add(user);
    }
    public void removeUser(){
        users.remove(user);
    }
    public void notifyUsers(String message,String emailAddress){
        for(User user:users){
            user.update(message,emailAddress);
        }
        done=true;

    }
    public boolean getDone(){
        return done;
    }
}
