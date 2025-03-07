import org.junit.jupiter.api.Test;
public class TestMain {
    @Test
    public void testAddition() {
        Calculator calculator = new Calculator(10, 5);
        assert calculator.add() == 15;
    }
}