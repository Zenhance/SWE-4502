package Class.Commands;

import Class.*;


public class UpdateCommentCommand implements Command {

    private IssueRepository issueRepository;
    private Issue issue;

    private Comment comment;

    public UpdateCommentCommand(IssueRepository issueRepository, Issue issue, Comment comment){
        this.issueRepository=issueRepository;
        this.issue=issue;
        this.comment=comment;
    }
    @Override
    public void Execute() {
         issueRepository.updateComment(issue,comment);
         System.out.println("Success");
    }

    @Override
    public void Undo() {
        //undo
    }
}
