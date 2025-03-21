package Lab_Final_210042150.Task_Management_System.Services;

import Lab_Final_210042150.Task_Management_System.Interfaces.Command;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class LoggingServices {
    private static LoggingServices instance;
    private final List<String> logs = new ArrayList<>();

    public LoggingServices(){}

    public static synchronized LoggingServices getInstance()
    {
        if(instance == null)
        {
            instance = new LoggingServices();
        }
        return instance;
    }

    public void logCommand(Command command)
    {
        String log = String.format("[%s] %s - %s",command.getTimestamp(),command.getType(),command.getDescription());
        logs.add(log);
    }

    public void logUndo(Command command)
    {
        String log = String.format("[%s] UNDO - %s",command.getTimestamp(),command.getDescription());
        logs.add(log);
    }

    public void logRedo(Command command)
    {
        String log = String.format("[%s] REDO - %s",command.getTimestamp(),command.getDescription());
    }







    public List<String> getLogs()
    {
        return new ArrayList<>(logs);
    }

    public int getLogCount()
    {
        return logs.size();
    }

}
