package Lab_final_210042166.Task_Management_System.Logger_Class;

import org.mockito.internal.matchers.Null;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance;
    private List <String>logs;

    private Logger(){
        logs=new ArrayList<>();
    }
    public static Logger getInstance()
    {
        if (instance== null)
        {
            instance=new Logger();
        }
        return instance;
    }
    public void log(String message)
    {
        logs.add(message);
    }
    public List<String>getLogs()
    {
        return logs;
    }


}
