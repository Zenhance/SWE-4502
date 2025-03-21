package Lab_final_210042166.Unit_Test.Command_Logging_Test;
import Lab_final_210042166.Task_Management_System.Logger_Class.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CommandLoggingTest {
    @Test
    public void Logger_ShouldStoreCommandHistoryLogs()
    {
        Logger logger=Logger.getInstance();
        logger.log("Executed Command 1");
        logger.log("Executed Command 2");

        assertEquals(2,logger.getLogs().size());
        assertEquals("Executed Command 1",logger.getLogs().get(0));
        assertEquals("Executed Command 2",logger.getLogs().get(1));
    }
}
