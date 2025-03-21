import org.junit.Test;
import org.junit.Assert;

public class test {
    @Test
    public void testArea(){
        AreaCalc areaCalc = new AreaCalc();
        Double result = areaCalc.squareArea(5);

        Assert.assertEquals(25.0, result, 0.001);
    }
}
