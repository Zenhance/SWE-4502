package concreteClasses.utility;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeManager {
    public boolean isTimeWithinLast10Minutes(String fetchedTime) {
        // Define a flexible formatter to handle both formats
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm[[:ss]]");

        try {
            // Parse the fetched time
            LocalDateTime fetchedDateTime = LocalDateTime.parse(fetchedTime, formatter);

            // Get the current time
            LocalDateTime currentTime = LocalDateTime.now();

            // Calculate the duration between the times
            Duration duration = Duration.between(fetchedDateTime, currentTime);

            // Return true if the time is within the last 10 minutes and not in the future
            return !fetchedDateTime.isAfter(currentTime) && duration.toMinutes() <= 10;

        } catch (DateTimeParseException e) {
            System.err.println("Invalid time format: " + fetchedTime);
            return false;
        }
    }

}
