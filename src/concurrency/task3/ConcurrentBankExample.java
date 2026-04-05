package concurrency.task3;

import javax.naming.InsufficientResourcesException;
import java.math.BigDecimal;

public class ConcurrentBankExample {
    public static void main(String[] args) {
        ConcurrentBank bank = new ConcurrentBank();

        // Создание счетов
        BankAccount account1 = bank.createAccount(BigDecimal.valueOf(1000));
        BankAccount account2 = bank.createAccount(BigDecimal.valueOf(500));

        // Перевод между счетами
        Thread transferThread1 = new Thread(() -> {
            try {
                bank.transfer(account1, account2, BigDecimal.valueOf(200));
            } catch (InsufficientResourcesException e) {
                throw new RuntimeException(e);
            }
        });
        Thread transferThread2 = new Thread(() -> {
            try {
                bank.transfer(account2, account1, BigDecimal.valueOf(100));
            } catch (InsufficientResourcesException e) {
                throw new RuntimeException(e);
            }
        });

        transferThread1.start();
        transferThread2.start();

        try {
            transferThread1.join();
            transferThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Вывод общего баланса
        System.out.println("Total balance: " + bank.getTotalBalance());
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());;
    }
}

