package observers;

import commands.Command;

public class NotificationService implements Observer{
    @Override
    public void update(Command command) {
        // Simulate sending notifications
        System.out.println("Notification: " + command.getDescription());
    }
}
