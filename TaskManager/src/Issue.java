import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Issue {
    public enum Priority { LOW, MEDIUM, HIGH, CRITICAL }
    public enum Status { OPEN, IN_PROGRESS, UNDER_REVIEW, RESOLVED, CLOSED }

        private static int counter = 1;
        private int ID;
        private String title;
        private String description;
        private Priority priority;
        private Status Statuss;
        private Date creationDate;
        private Date lastModifiedDate;
        private String assignedTo;
        private List<String> tags = new ArrayList<>();
        private List<Comment> comments = new ArrayList<>();

        public Issue(String title, String description, Priority priority) {
            this.ID = counter++;
            this.title = title;
            this.description = description;
            this.priority = priority;
            this.Statuss = Status.OPEN;
            this.creationDate = new Date();
            this.lastModifiedDate = new Date();
        }

        public void updateStatus(Status newStatus) {
            this.Statuss = newStatus;
            this.lastModifiedDate = new Date();
        }

        public void addComment(Comment comment) {
            this.comments.add(comment);
            this.lastModifiedDate = new Date();
        }

        public int getId() { return ID; }
        public Status getStatus() { return Statuss; }
        public List<Comment> getComments() { return comments; }
    }
