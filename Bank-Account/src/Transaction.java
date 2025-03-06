import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private TransactionType type;

    private String accountID;
    private double amount;
    private LocalDateTime timestamp;

    private String reference;

public Transaction(TransactionType type, String accountID, double amount, String reference) {
        this.id = "T" + System.currentTimeMillis();
        this.type = type;
        this.accountID = accountID;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.reference = reference;
    }


    public String getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public String getAccountID() {
        return accountID;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getReference() {
        return reference;
    }







}
