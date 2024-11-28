package utilities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeManager {
    
    public boolean isTimeWithinLast10Minutes(String fetchedTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime fetchedDateTime = LocalDateTime.parse(fetchedTime, formatter);

        LocalDateTime currentTime = LocalDateTime.now();

        Duration duration = Duration.between(fetchedDateTime, currentTime);

        return !fetchedDateTime.isAfter(currentTime) && duration.toMinutes() <= 10;
    }
}
