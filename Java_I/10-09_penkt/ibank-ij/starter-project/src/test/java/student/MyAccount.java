package student;

import ibank.Account;

import java.math.BigDecimal;

public class MyAccount implements Account {

    private final String number;
    private final String holderName;
    private final BigDecimal creditLimit;            // 0 for a debit account
    private BigDecimal balance = BigDecimal.ZERO;    // starts at zero

    public MyAccount(String number, String holderName, BigDecimal creditLimit) {
        this.number = number;
        this.holderName = holderName;
        this.creditLimit = creditLimit;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getHolderName() {
        return holderName;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public boolean deposit(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            return false;
        }
        balance = balance.add(amount);
        return true;
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            return false;
        }

        BigDecimal newBalance = balance.subtract(amount);

        if (newBalance.compareTo(creditLimit.negate()) < 0) {
            return false;
        }

        balance = newBalance;
        return true;
    }
}
