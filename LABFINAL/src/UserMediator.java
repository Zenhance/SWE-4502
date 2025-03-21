

import java.util.ArrayList;
import java.util.List;

public class UserMediator {
    private List<User> users;

    public UserMediator() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void notifyUsers(String message) {
        for (User user : users) {

        }

    } }
