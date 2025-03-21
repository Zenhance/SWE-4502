package taskmanager;
import command.AbstractCommand;
import command.Command;
import command.CommandType;

public class UndoLogCommand extends AbstractCommand
{
        private final Command undoneCommand;

        public UndoLogCommand(Command undoneCommand) {
                super(CommandType.Update);
                this.undoneCommand = undoneCommand;
        }
        @Override
        public void execute() {
        }

        @Override
        public void undo()
        {
        }

        @Override
        public String getDescription()
        {
                return "UNDO: " + undoneCommand.getDescription();
        }
}





