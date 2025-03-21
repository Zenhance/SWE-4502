package com.taskmanager.model;

import java.util.Date;

public class OperationLog {
    private String description;
    private Date timestamp;
    private String type;

    public OperationLog(String description,Date timestamp,String type) {
        this.description=description;
        this.timestamp = timestamp;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

