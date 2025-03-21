package Lab_final_210042166.Unit_Test.Statistics_Collection_Test;
import Lab_final_210042166.Task_Management_System.Statistics.StatisticsCollector;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StatisticsCollectionTest {
    @Test
    public void StatisticsCollector_ShouldTrackCommandCounts()
    {
        StatisticsCollector collector=new StatisticsCollector();
        collector.incrementCreateCount();
        collector.incrementUpdateCount();
        collector.incrementDeleteCount();

        assertEquals(1,collector.getCreateCount());
        assertEquals(1,collector.getUpdateCount());
        assertEquals(1,collector.getDeleteCount());
    }
}
