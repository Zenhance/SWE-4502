package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");

        //   public static void main(String[] args){
//     Light livingRoomLight= new Light();
//     Command lightOn= new LightOnCommand(livingRoomLight);
//     Command LightOff= new LightOffCommand(livingRoomLight);
//
//     RemoteControl remote= new RemoteControl();
//     remote.setCommand(lightOn);
//     remote.pressButton();
//     remote.setCommand(lightOff);
//     remote.pressButton();
//   }
        Issue labIssue= new Issue();
        Command CreateIssue= new CreateIssueCommand(labIssue);
        Command UpdateIssue= new UpdateIssueCommand(labIssue);
//        Command ChangeIssueStatus= new ChangeIssueStatusComand(labIssue);

        RemoteControl remote= new remoteControl();
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