public class TaskManagerMediator {
    private final CommandManager commandManager;
    private final OperationLogger logger;
    private final NotificationService notificationService;
    private final StatisticsCollector statisticsCollector;

    public TaskManagerMediator() {
        this.commandManager = new CommandManager();
        this.logger = new OperationLogger();
        this.notificationService = new NotificationService();
        this.statisticsCollector = new StatisticsCollector();
    }

    public void executeCommand(Command command) {
        commandManager.executeCommand(command);
        logger.logOperation(command);
        notificationService.notifyObservers(command);
        statisticsCollector.collectStatistics(command);
    }

    public void undoCommand() {
        if (commandManager.canUndo()) {
            commandManager.undo();
        }
    }

    public void redoCommand() {
        if (commandManager.canRedo()) {
            commandManager.redo();
        }
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public OperationLogger getLogger() {
        return logger;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public StatisticsCollector getStatisticsCollector() {
        return statisticsCollector;
    }
}
