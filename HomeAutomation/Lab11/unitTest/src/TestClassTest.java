import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
class TestClassTest {

    @Test
    void isOdd() {
        TestClass tClass = new TestClass();
        Assertions.assertTrue(tClass.isOdd(73));
    }
}