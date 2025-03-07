import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.example.ClassA;

public class TestClassA {
    
    @Test
    public void compareTest(){
        ClassA classA = new ClassA();
        int result = classA.compare(10, 10);
        Assertions.assertEquals(1, result);
    }
}
