package concreteClasses.utility;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeManager {
    public boolean isTimeWithinLast10Minutes(String fetchedTime) {
        // Define the formatter matching the date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Parse the fetched time to a LocalDateTime object
        LocalDateTime fetchedDateTime = LocalDateTime.parse(fetchedTime, formatter);

        // Get the current time
        LocalDateTime currentTime = LocalDateTime.now();

        // Calculate the duration between current time and fetched time
        Duration duration = Duration.between(fetchedDateTime, currentTime);

        // Return true if fetchedDateTime is not in the future and within 10 minutes
        return !fetchedDateTime.isAfter(currentTime) && duration.toMinutes() <= 10;
    }
}
