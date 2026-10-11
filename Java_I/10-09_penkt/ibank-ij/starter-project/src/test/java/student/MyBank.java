package student;

import ibank.Account;
import ibank.Bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MyBank implements Bank {

    private final List<Account> accounts  = new ArrayList<>();
    private int nextNumber = 1; // for unique account numbers

    @Override
    public int getNumberOfAccounts() {

        return accounts.size();
    }

    @Override
    public BigDecimal getTotalReserves() {
        return accounts.stream()
                .map(account -> account.getBalance())
                .reduce(BigDecimal.ZERO, (sum, balance) -> sum.add(balance));
    }

    @Override
    public Collection<Account> getAllAccounts() {

        return Collections.unmodifiableList(accounts);
    }

    @Override
    public Account openDebitAccount(String s) {
        if (s == null || s.isBlank()) {
            return null;
        }
        if (getAccountByHolderName(s) != null) {
            return null;
        }

        Account account = new MyAccount("ACC-" + nextNumber, s, BigDecimal.ZERO);
        nextNumber++;
        accounts.add(account);
        return account;
    }

    @Override
    public Account openCreditAccount(String s, BigDecimal amount) {
        if (s == null || s.isBlank() || amount == null || amount.signum() < 0) {
            return null;
        }
        if (getAccountByHolderName(s) != null) {
            return null;
        }

        Account account = new MyAccount("ACC-" + nextNumber, s, amount);
        nextNumber++;
        accounts.add(account);
        return account;
    }

    @Override
    public Account getAccountByHolderName(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        return accounts.stream()
                .filter(name -> name.getHolderName().equals(s))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Account getAccountByNumber(String s) {

        if (s == null || s.equals("")) {
            return null;
        }
        return accounts.stream()
                .filter(name -> name.getNumber().equals(s))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void closeAccount(Account account) {
        accounts.remove(account);
    }
}
