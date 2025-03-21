public interface Subject{
    void addUser(User user);
    void removeUser(User user);
    void notifyUsers(String message,String emailAddress);
}