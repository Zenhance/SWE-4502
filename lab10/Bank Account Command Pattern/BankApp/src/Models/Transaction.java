package Models;

import java.util.Date;

public class Transaction {
    private String type;
    private double amount;
    private Date date;
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date =  new Date();
    }
    public String getType() {
        return type;
    }
    public double getAmount() {
        return amount;
    }
    public Date getDate() {
        return date;
    }
}
