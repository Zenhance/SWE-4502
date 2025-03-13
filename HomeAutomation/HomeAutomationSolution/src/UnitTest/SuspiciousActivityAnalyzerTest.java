package UnitTest;

import MotionDetection.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class SuspiciousActivityAnalyzerTest {
    @Test
    void testSuspiciousActivityAtNight() {
        SuspiciousActivityAnalyzer analyzer = new SuspiciousActivityAnalyzer();
        List<MotionEvent> history = new ArrayList<>();
        history.add(new MotionEvent(LocalDateTime.of(2025, 3, 13, 2, 30))); // 2:30 AM

        assertTrue(analyzer.isSuspicious(history), "Motion detected at night should be suspicious.");
    }

    @Test
    void testNormalActivityDuringDay() {
        SuspiciousActivityAnalyzer analyzer = new SuspiciousActivityAnalyzer();
        List<MotionEvent> history = new ArrayList<>();
        history.add(new MotionEvent(LocalDateTime.of(2025, 3, 13, 14, 0))); // 2:00 PM

        assertFalse(analyzer.isSuspicious(history), "Motion during daytime should not be suspicious.");
    }
}
