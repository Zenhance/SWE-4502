package utilities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimestampValidator {
    public boolean isWithinLastTenMinutes(String timestamp) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime parsedTime = LocalDateTime.parse(timestamp, dateFormatter);
        LocalDateTime currentTime = LocalDateTime.now();
        Duration timeDifference = Duration.between(parsedTime, currentTime);

        return !parsedTime.isAfter(currentTime) && timeDifference.toMinutes() <= 10;
    }
}