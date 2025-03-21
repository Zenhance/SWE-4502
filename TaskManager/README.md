# Task Manager

You need to develop a task management system that simulates popular issue trackers (e.g: Trello, JIRA). For simplicity, we will be only working with a single domain model that will be called `Issue`. Typically, an issue should hold some basic properties like:

* `Id`
* `Title`
* `Description`
* `Priority`
* `Status`
* `CreationDate`
* `LastModifiedDate`
* `AssignedTo`
* `Tags` [can be multiple]
* `Comments` [can be multiple]

Each `Comment` should have their own properties to hold:

* `Id`
* `Content`
* `Author`
* `CreatedAt`

`Priority` should hold some predefined value to choose from : `Low`,`Medium`,`High`,`Critical`.
As well as the `Status` of an `Issue` should be any one of this :`Open`, `InProgress`, `UnderReview`, `Resolved`, `Closed`.

---

### Funtional Requirements

#### Executable operations on issues and related entites

- Implement functionalities for creating, updating and changing the status of issues. [Details are listed in the following numberd points]
- Each operation below should support *execution* and *undo*.
- To maintain consistency, ***upon undoing some operations and then doing a new operation, previously undone operations (aforementioned) can not be redone.*** (e.g. lets say a series of operations such as, $A \rightarrow B \rightarrow C \rightarrow D$ is executed, then two undo operations are executed. Now, $C \rightarrow D$ is undone.  Afterwards, if a new operation $X$ is performed, then $C \rightarrow D$ cannot be redone anymore.)
- Each operation below should maintain metadata of `Description`, `Timestamp` and `Type` for logging purpose of that operation.
- `Type` of command should be categorized as `Create`,`Update` or `Delete`.

1. **Create Issue**

    - Create a new issue in the repository.
    - For simplicity create a `IssueRepository` class where you hold all the issues inside a HashMap.

2. **Update Issue**

    - Update the details/properties of an existing issue.

3. **Change Issue Status**

    - Change the status of a specific issue.

4. **Add Comments**

    - Add a comment(s) to a specific issue.

5. **Log Operation**

    - Log each operation with a timestamp and description.
    - Maintain a `private` list of logs for the access of log history.
    - Enable a mechanism for log access

6. **Trigger Notification**

    - Notify users of specific operation executions, such as issue creation and status changes.
    - Simulate sending notifications, such as emails.

7. **Statistics Collector**

    - Track the number of commands executed by type.
    - Maintain statistics on issues created in the applications lifecycle.

---

### Unit Tests as Issues

###### Issue #F01: Create Issue Test

Test: `____CreateIssue_ShouldAddIssueToRepository`

* Act: Create a new issue with title, description, and priority
* Assert: Verify that the issue exists in repository with correct properties and default status

###### Issue #F02: Add Comment Test

Test: `____AddComment_ShouldAddCommentToIssue`

* Act: Add a comment to an existing issue
* Assert: Verify comment is added with correct content and author

###### Issue #F03: Change Status Test

Test: `ChangeStatus_ShouldUpdateIssueStatus`

* Act: Change the status of an existing issue
* Assert: Verify the issue status is updated to the new value

###### Issue #F04: Undo Command Test

Test: `UndoCommand_ShouldRevertLastAction`

* Act: Execute a command and then undo it
* Assert: Verify the system state is reverted to its previous state

###### Issue #F05: Redo Command Test

Test: `RedoCommand_ShouldReapplyUndoneAction`

* Act: Execute a command, undo it, then redo it
* Assert: Verify the system state reflects the reapplied command

###### Issue #F06: Observer Notification Test

Test: `Observer_ShouldBeNotifiedOfCommands`

* Act: Execute a command with registered observer
* Assert: Verify observer was notified of the command execution

###### Issue #F07: Statistics Collection Test

Test: `StatisticsCollector_ShouldTrackCommandCounts`

* Act: Execute multiple commands
* Assert: Verify command counts are tracked correctly by type

###### Issue #F08: Command Logging Test

Test: `Logger_ShouldStoreCommandHistoryLogs`

* Act: Execute multiple commands
* Assert: Verify logs contain correct command descriptions and count

###### Issue #F09: Multiple Observers Test

Test: `MultipleObservers_ShouldAllBeNotified`

* Act: Execute command with multiple registered observers
* Assert: Verify all observers were notified exactly once

###### Issue #F10: Observer Removal Test

Test: `RemoveObserver_ShouldStopNotifications`

* Act: Execute commands before and after removing an observer
* Assert: Verify observer stops receiving notifications after removal

###### Issue #F11: Command History Test

Test: `CommandHistory_ShouldTrackAllExecutedCommands`

* Act: Execute multiple commands
* Assert: Verify command history contains all executed commands in correct order

###### Issue #F12: Undo/Redo Stack Test

Test: `UndoRedo_ShouldMaintainProperStacks`

* Arrange: Create an issue and change its status twice.
* Act: Undo the last executed command twice
* Act: Redo one command that was just undone.
* Act: Perform a new command
* Act: Try to redo again
* Assert : The issue status is what it should be after each act is performed.
* Assert: Verify command stack maintains correct state after operations.

###### Issue #F13: Deep Clone Test

Test: `Issue_Clone_ShouldCreateCompleteDeepCopy`

* Act: Create and clone an issue with all properties set
* Assert: Verify clone is independent copy with identical values

###### Issue #F14: Status Change Logging Test

Test: `ChangeIssueStatusCommand_ShouldLogCorrectDescription`

* Act: Change issue status and check logs
* Assert: Verify log contains correct status change description

###### Issue #F15: Notification Service Test

Test: `NotificationService_ShouldNotifyOnStatusChanges`

* Act: Create issue and change its status
* Assert: Verify notification service receives correct number of notifications

### Suggestions

* You can maintain a service class along with a `IssuesRepository` mentioned in point 2 for better code management.
* You can maintain another class to manage execution/undo of operations.

---

## After you are finished with your implementation prepare a PDF report on the patterns you have used to solve the problem and the rationale behind it.

---

