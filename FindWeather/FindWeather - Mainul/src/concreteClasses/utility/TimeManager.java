package concreteClasses.utility;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeManager {
    public boolean isTimeWithinLast10Minutes(String fetchedTime) {
        // Define the formatter to parse the time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        // Parse fetched time to LocalTime
        LocalTime fetchedLocalTime = LocalTime.parse(fetchedTime, formatter);

        // Get the current time
        LocalTime now = LocalTime.now();

        // Calculate the difference in minutes
        long minutesDifference = ChronoUnit.MINUTES.between(fetchedLocalTime, now);

        // Check if the difference is within the last 10 minutes
        return minutesDifference >= 0 && minutesDifference <= 10;
    }
}
