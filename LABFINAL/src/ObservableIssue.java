class ObservableIssue extends Issue {
    private IssueNotifier notifier;

    public ObservableIssue(int id, String title, String description, Priority priority, Status status, String assignedTo) {
        super(id, title, description, priority, status, assignedTo); // Add assignedTo
        this.notifier = new IssueNotifier();
    }

    public void addObserver(Observer observer) {
        notifier.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        notifier.removeObserver(observer);
    }

    @Override
    public void changeStatus(Status newStatus) {
        super.changeStatus(newStatus);
        notifier.notifyObservers("Issue status changed to: " + newStatus);
    }
}

