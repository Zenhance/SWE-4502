package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepository {
    @Test
    void CreateIssue_ShouldAddIssueToRepository(){
        Issue issue= new Issue();
        issue.createIssue();
        assertTrue(issue.toString().contains("Issue created"));
    }

    @Test
    void ChangeStatus_ShouldUpdateIssueStatus(){
        Issue issue= new Issue();
        issue.changeIssueStatus();
        assertTrue(issue.toString().contains("Issue status changed"));
    }

    @Test
    void UndoCommand_ShouldRevertLastAction(){
//        Issue issue= new Issue();
        UndoRedo ud= new UndoRedo();
        ud.executeCommand(this::UndoCommand_ShouldRevertLastAction);
        ud.undo();
        assertTrue(issue.toString().contains("handling undo-redo of comments"));
    }
    @Test
    public void RedoCommand_ShouldReapplyUndoneAction(){
//        Issue issue= new Issue();
        UndoRedo ud= new UndoRedo();
        ud.executeCommand(this::RedoCommand_ShouldReapplyUndoneAction);
        ud.undo();
        assertTrue(issue.toString().contains("handling undo-redo of comments"));
    }
    @Test
    public void AddComment_ShouldAddCommentToIssue(){
//        Issue issue= new Issue();
        Comment comment= new Comment(content, author);
        assertTrue(issue.toString().contains("Comment added"));
    }
    @Test
    public void Observer_ShouldBeNotifiedOfCommands(){
        EmailNotifier email= new EmailNotifier();
        email.pushNotif(message);
        assertTrue(issue.toString().contains("Message sent: "+message));
    }
    @Test
    public void NotificationService_ShouldNotifyOnStatusChanges(){
        NotificationService notifservice= new NotificationService();
        notifservice.addObserver();
        notifservice.removeObserver();
        notifservice.notifyObservers();
    }
}

//////////////////////////////////////////////////////////
/*
Unit Tests as Issues
Issue #F01: Create Issue Test
Test: CreateIssue_ShouldAddIssueToRepository
Act: Create a new issue with title, description, and priority
Assert: Verify that the issue exists in repository with correct properties and default status

Issue #F02: Add Comment Test
Test: AddComment_ShouldAddCommentToIssue
Act: Add a comment to an existing issue
Assert: Verify comment is added with correct content and author

Issue #F03: Change Status Test
Test: ChangeStatus_ShouldUpdateIssueStatus
Act: Change the status of an existing issue
Assert: Verify the issue status is updated to the new value

Issue #F04: Undo Command Test
Test: UndoCommand_ShouldRevertLastAction
Act: Execute a command and then undo it
Assert: Verify the system state is reverted to its previous state

Issue #F05: Redo Command Test
Test: RedoCommand_ShouldReapplyUndoneAction
Act: Execute a command, undo it, then redo it
Assert: Verify the system state reflects the reapplied command

Issue #F06: Observer Notification Test
Test: Observer_ShouldBeNotifiedOfCommands
Act: Execute a command with registered observer
Assert: Verify observer was notified of the command execution

Issue #F07: Statistics Collection Test
Test: StatisticsCollector_ShouldTrackCommandCounts
Act: Execute multiple commands
Assert: Verify command counts are tracked correctly by type

Issue #F08: Command Logging Test
Test: Logger_ShouldStoreCommandHistoryLogs
Act: Execute multiple commands
Assert: Verify logs contain correct command descriptions and count

Issue #F09: Multiple Observers Test
Test: MultipleObservers_ShouldAllBeNotified
Act: Execute command with multiple registered observers
Assert: Verify all observers were notified exactly once

Issue #F10: Observer Removal Test
Test: RemoveObserver_ShouldStopNotifications
Act: Execute commands before and after removing an observer
Assert: Verify observer stops receiving notifications after removal

Issue #F11: Command History Test
Test: CommandHistory_ShouldTrackAllExecutedCommands
Act: Execute multiple commands
Assert: Verify command history contains all executed commands in correct order

Issue #F12: Undo/Redo Stack Test
Test: UndoRedo_ShouldMaintainProperStacks
Arrange: Create an issue and change its status twice.
Act: Undo the last executed command twice
Act: Redo one command that was just undone.
Act: Perform a new command
Act: Try to redo again
Assert : The issue status is what it should be after each act is performed.
Assert: Verify command stack maintains correct state after operations.

Issue #F13: Deep Clone Test
Test: Issue_Clone_ShouldCreateCompleteDeepCopy
Act: Create and clone an issue with all properties set
Assert: Verify clone is independent copy with identical values

Issue #F14: Status Change Logging Test
Test: ChangeIssueStatusCommand_ShouldLogCorrectDescription
Act: Change issue status and check logs
Assert: Verify log contains correct status change description

Issue #F15: Notification Service Test
Test: NotificationService_ShouldNotifyOnStatusChanges
Act: Create issue and change its status
Assert: Verify notification service receives correct number of notifications
 */