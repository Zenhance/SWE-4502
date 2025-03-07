package Query;

import App.bank;

public class ShowTransactionHistoryQuery implements iQuery {
    private bank bank;
    private String accountNumber;

    public ShowTransactionHistoryQuery(bank bank, String accountNumber) {
        this.bank = bank;
        this.accountNumber = accountNumber;
    }

    @Override
    public void query() {
        bank.showTransactionHistory(accountNumber);
    }
}
