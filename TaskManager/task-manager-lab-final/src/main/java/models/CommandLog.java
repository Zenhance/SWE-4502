package models;

import java.security.Timestamp;

public class CommandLog {
    private String description;
    private Timestamp timestamp;
    private CommandType type;

    public CommandLog(String description, Timestamp timestamp, CommandType type){
        this.description = description;
        this.timestamp = timestamp;
        this.type = type;
    }
}
