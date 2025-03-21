package com.taskmanager.command;


import com.taskmanager.repository.IssueRepository;

public interface Command {
    void execute();
    void undo();
}

