package Query;

import App.bank;

public class ShowBalance implements iQuery {
    private bank bank;
    private String accountNumber;

    public ShowBalance(bank bank, String accountNumber) {
        this.bank = bank;
        this.accountNumber = accountNumber;
    }

    @Override
    public void query() {
        bank.showBalance(accountNumber);
    }
}
