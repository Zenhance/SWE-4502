package command;

import issues.Issue;
import user.User;

public class CreateIssueCommand implements Command {
    public User user;
    @Override
    public void execute() {
        user.createIssue("hello","world");


    }

    @Override
    public void unexecute() {

    }
}
