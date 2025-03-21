public interface Command {
    Issue execute();
    Issue undo();
}
