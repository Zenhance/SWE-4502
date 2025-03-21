import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger {

    private Date timestamp;
    private String description;
    private List<Logger> logs = new ArrayList<>();

    private Logger(){}

    private void addLog(Logger log){
        logs.add(log);
    }
    private  void getLog(){

    }

}
