package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Issue labIssue= new Issue();
        Command CreateIssue= new CreateIssueCommand(labIssue);
        Command UpdateIssue= new UpdateIssueCommand(labIssue);

//        RemoteControl remote= new remoteControl();
    }
}

////////////////////////////
/*
Strategy Pattern
Command Pattern

Command Interface;
Concrete Command Classes:
    CreateIssueCommand
    UpdateIssueCommand
    UpdateIssueCommand

*/