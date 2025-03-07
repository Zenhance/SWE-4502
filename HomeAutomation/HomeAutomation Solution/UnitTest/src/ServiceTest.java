import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    @Test
    void isOddTest(){
        Service service = new Service();
        String result = service.isOdd(3);

        Assertions.assertEquals("odd", result);
    }
}