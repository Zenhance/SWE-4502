package interfaces;

import java.util.Date;

public abstract class Command {


    public abstract void  execute();
    public abstract void undo();
    public String description;
    private String type;
    private Date timestamp;
    public Command(String description, String type) {
        this.description = description;
        this.timestamp = new Date();
        this.type = type;
    }
    public String getDescription(){
        return description;
    }

    public String getType() {
        return type;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
