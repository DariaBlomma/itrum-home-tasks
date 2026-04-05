package concurrency.task3;

import javax.naming.InsufficientResourcesException;
import java.math.BigDecimal;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentBank {
    private final CopyOnWriteArrayList<BankAccount> accounts = new CopyOnWriteArrayList<>();

    BankAccount createAccount(BigDecimal balance) {
        BankAccount newAcc = new BankAccount(balance);
        accounts.add(newAcc);
        return newAcc;
    }

    void transfer(BankAccount from, BankAccount to, BigDecimal amount) throws InsufficientResourcesException {
        BankAccount first;
        BankAccount second;

        if (from.getId() < to.getId()) {
            first = from;
            second = to;
        } else {
            first = to;
            second = from;
        }

        first.getWriteLock().lock();
        second.getWriteLock().lock();

        try {
            from.withdraw(amount);
            to.deposit(amount);
        } finally {
            second.getWriteLock().unlock();
            first.getWriteLock().unlock();
        }
    }

    BigDecimal getTotalBalance() {
        return accounts.stream().map(BankAccount::getBalance).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
