interface ICommand {
    void execute();
    void undo();
    String getDescription();
}

