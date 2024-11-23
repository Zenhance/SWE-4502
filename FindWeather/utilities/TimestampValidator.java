package utilities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampValidator {
    public boolean isWithinLastTenMinutes(String timestamp) {