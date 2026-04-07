package concurrency.task3;

import javax.naming.InsufficientResourcesException;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {
    private BigDecimal balance;
    private final int id;

    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    public BankAccount(BigDecimal balance) {
        this.balance = balance;
        id = idGenerator.getAndIncrement();
    }

    void deposit(BigDecimal amount) {
        writeLock.lock();
        try {
           balance = balance.add(amount);
        } finally {
            writeLock.unlock();
        }
    }

    void withdraw(BigDecimal amount) throws InsufficientResourcesException {
        writeLock.lock();
        try {
            if (amount.compareTo(balance) == 1) {
                throw new InsufficientResourcesException("Not enough balance to withdraw" + amount.toString());
            }
            balance = balance.subtract(amount);
        } finally {
            writeLock.unlock();
        }
    }

    BigDecimal getBalance() {
        readLock.lock();
        try {
            return balance;
        } finally {
            readLock.unlock();
        }
    }

    public int getId() {
        return id;
    }

    public ReentrantReadWriteLock.WriteLock getWriteLock() {
        return rwLock.writeLock();
    }
}
