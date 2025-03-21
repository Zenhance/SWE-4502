package taskmanager;
import command.AbstractCommand;
import command.Command;
import command.CommandType;

public class RedoLogCommand extends AbstractCommand
{
    private final Command redoneCommand;

    public RedoLogCommand(Command redoneCommand)
    {
        super(CommandType.Update);
        this.redoneCommand = redoneCommand;
    }

    @Override
    public void execute() {
    }

    @Override
    public void undo() {
    }

    @Override
    public String getDescription() {
        return "REDO: " + redoneCommand.getDescription();
    }
}
