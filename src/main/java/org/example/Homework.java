package org.example;
import java.time.LocalDate;

public class Homework {

    public static class Account {
        private double balance;

        public Account() {
            this.balance = 0.0;
        }

        public int put(double amount) {
            if (amount > 0) {
                balance += amount;
            }
            return 0;
        }

        public void take(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            }
        }

        public double getAmount() {
            return balance;
        }
    }

    public static class CreditAccount extends Account {
        @Override
        public void take(double amount) {
            if (amount > 0 && amount <= getAmount()) {
                double fee = amount * 0.01;
                super.take(amount + fee);
            }
        }
    }

    public static class DepositAccount extends Account {
        private LocalDate lastWithdrawDate;

        public DepositAccount() {
            this.lastWithdrawDate = LocalDate.now();
        }

        @Override
        public void take(double amount) {
            LocalDate currentDate = LocalDate.now();
            if (amount > 0 && amount <= getAmount() && currentDate.isAfter(lastWithdrawDate.plusMonths(1))) {
                super.take(amount);
                lastWithdrawDate = currentDate;
            }
        }
    }

    public static void main(String[] args) {
        Account regularAccount = new Account();
        CreditAccount creditAccount = new CreditAccount();
        DepositAccount depositAccount = new DepositAccount();

        regularAccount.put(1000);
        regularAccount.take(500);

        creditAccount.put(1000);
        creditAccount.take(100);

        depositAccount.put(1000);
        depositAccount.take(500);

        System.out.println("Regular Account Balance: " + regularAccount.getAmount());
        System.out.println("Credit Account Balance: " + creditAccount.getAmount());
        System.out.println("Deposit Account Balance: " + depositAccount.getAmount());
    }
}