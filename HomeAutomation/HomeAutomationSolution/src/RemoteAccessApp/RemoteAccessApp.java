package RemoteAccessApp;


import CoreFramework.EnvironmentState;
import CoreFramework.Observer;

import java.util.ArrayList;
import java.util.List;

// Allows users to monitor and control smart home remotely
public class RemoteAccessApp implements Observer {
    private EnvironmentState currentState;
    private List<String> notifications;
    private NotificationService notificationService;

    public RemoteAccessApp(NotificationService notificationService) {
        this.notifications = new ArrayList<>();
        this.notificationService = notificationService;
    }

    @Override
    public void update(EnvironmentState state) {
        this.currentState = state;
        System.out.println(" Remote App Updated: " + state);
        checkForAlerts();
    }

    private void checkForAlerts() {
        if (currentState.getLightLevel()*100 > 5000) {
            sendNotification(" High Power Usage: " + currentState.getLightLevel()*100 + "W");
        }
        if (currentState.getTemperature() > 30) {
            sendNotification(" Warning: High Temperature Detected (" + currentState.getTemperature() + "°C)");
        }
    }

    private void sendNotification(String message) {
        notifications.add(message);
        notificationService.sendNotification(message);
    }

    public List<String> getNotifications() {
        return notifications;
    }
}
