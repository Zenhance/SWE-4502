import java.util.logging.Logger;

public class RemoteApp implements Observer {
    private static final Logger logger = Logger.getLogger(RemoteApp.class.getName());
    private boolean notificationReceived = false;
    private String currentState = "Idle";
    private static final double TEMPERATURE_THRESHOLD = 25.0;  // Example threshold for notifications

    @Override
    public void update(String state, Object value) {
        // Handle state changes and display information or send notifications
        if ("TEMPERATURE".equals(state) && value instanceof Double) {
            double currentTemperature = (Double) value;
            // Log current temperature
            logger.info("RemoteApp: Temperature updated to " + currentTemperature + "°C");

            // Check for significant temperature changes
            if (currentTemperature > TEMPERATURE_THRESHOLD) {
                generateNotification("Temperature exceeds threshold!", "Current temperature: " + currentTemperature + "°C");
            }
        }

        if ("MOTION".equals(state) && value instanceof Boolean) {
            boolean motionDetected = (Boolean) value;
            if (motionDetected) {
                generateNotification("Motion detected!", "Motion detected at home.");
            } else {
                logger.info("RemoteApp: No motion detected.");
            }
        }

        // Additional states like lighting or humidity can be handled here
    }

    // Simulate generating a notification for important events
    private void generateNotification(String title, String message) {
        notificationReceived = true;
        logger.info("RemoteApp Notification: " + title + " - " + message);
    }

    public boolean isNotificationReceived() {
        boolean wasReceived = notificationReceived;
        notificationReceived = false;  // Reset after reading the notification
        return wasReceived;
    }

    // Set the state of the RemoteApp (e.g., to show it is 'Active' or 'Idle')
    public void setState(String state) {
        currentState = state;
        logger.info("RemoteApp: State changed to " + state);
    }

    public String getCurrentState() {
        return currentState;
    }
}