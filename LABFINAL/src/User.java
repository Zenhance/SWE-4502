public class User {
    public String name;

    public User(String name) {
        this.name = name;
    }

    public void receiveEmail(String message) {
        System.out.println(name + " received: " + message);
    }
}

