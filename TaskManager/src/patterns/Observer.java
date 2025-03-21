package patterns;

public interface Observer {
    void update(String message);

    int getNotificationCount();
}