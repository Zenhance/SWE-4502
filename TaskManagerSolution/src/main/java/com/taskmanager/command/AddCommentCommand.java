package com.taskmanager.command;

import com.taskmanager.model.Comment;
import com.taskmanager.service.IssueService;

public class AddCommentCommand implements Command {
    private IssueService issueService;
    private String issueId;
    private Comment comment;

    public AddCommentCommand(IssueService issueService, String issueId, Comment comment) {
        this.issueService = issueService;
        this.issueId = issueId;
        this.comment = comment;
    }

    @Override
    public void execute() {
        issueService.addComment(issueId, comment);
    }

    @Override
    public void undo() {
        // Implement undo logic
    }
}