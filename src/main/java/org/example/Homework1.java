package org.example;
import java.time.LocalDate;

public class Homework1 {

    public static class Account {
        private double balance;

        public void put(double amount) {
            if (amount > 0) {
                balance += amount;
            }
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
        private static final double COMMISSION_RATE = 0.01;

        @Override
        public void take(double amount) {
            if (amount > 0 && amount <= getAmount()) {
                double commission = amount * COMMISSION_RATE;
                super.take(amount + commission);
            }
        }
    }

    public static class DepositAccount extends Account {
        private LocalDate lastWithdrawalDate;

        @Override
        public void take(double amount) {
            if (amount > 0 && amount <= getAmount() && canWithdraw()) {
                super.take(amount);
                lastWithdrawalDate = LocalDate.now();
            }
        }

        private boolean canWithdraw() {
            if (lastWithdrawalDate == null) {
                return true;
            } else {
                LocalDate currentDate = LocalDate.now();
                return currentDate.isAfter(lastWithdrawalDate.plusMonths(1));
            }
        }
    }

    public static void main(String[] args) {
        Account account = new Account();
        account.put(1000);
        account.take(200);
        System.out.println("Account balance: " + account.getAmount());

        CreditAccount creditAccount = new CreditAccount();
        creditAccount.put(1000);
        creditAccount.take(200);
        System.out.println("Credit account balance: " + creditAccount.getAmount());

        DepositAccount depositAccount = new DepositAccount();
        depositAccount.put(1000);
        depositAccount.take(200);
        System.out.println("Deposit account balance: " + depositAccount.getAmount());
    }
}