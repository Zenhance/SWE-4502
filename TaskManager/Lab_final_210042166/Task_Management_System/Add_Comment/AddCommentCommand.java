package Lab_final_210042166.Task_Management_System.Add_Comment;

import Lab_final_210042166.Task_Management_System.Comment.Comment;
import Lab_final_210042166.Task_Management_System.Interface.Command;
import Lab_final_210042166.Task_Management_System.Issue.Issue;

public class AddCommentCommand  implements Command {
  private Issue issue;
  private Comment comment;

  public AddCommentCommand(Issue issue,Comment comment)
  {
      this.issue=issue;
      this.comment=comment;
  }


    @Override
    public void execute()
    {
        issue.addComment(comment);
    }

    @Override
    public void undo()
    {
        issue.getComments().remove(comment);
    }
}
