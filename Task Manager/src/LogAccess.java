public class LogAccess {
    private Logger logger;

    public LogAccess(Logger logger) {
        this.logger = logger;
    }

    public void printLogs() {
        for (String log : logger.getLogs()) {
            System.out.println(log);
        }
    }
}
