package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import main.Greeter;

public class GreeterTests {

    @Test
    public void testGreeter() {
        Greeter greeter = new Greeter();
        String greetString = greeter.greet("hasin023");

        assertEquals("Goodbye hasin023 🔥🔥🔥 ", greetString);
    }
}