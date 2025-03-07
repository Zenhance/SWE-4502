import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Service2Test {

    @Test
    void isOddTest(){
        Service2 service2=new Service2();
        Assertions.assertTrue(service2.isOdd(3));
    }

}