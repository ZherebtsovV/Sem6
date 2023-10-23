package org.example;

public class Homework2 {

    public interface Account {
        double getAmount();
        void put(double amount);
        void take(double amount);
    }

    public abstract static class AbstractAccount implements Account {
        private double balance;

        public AbstractAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        @Override
        public void put(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        @Override
        public final void take(double amount) {
            if (amount >= 0) {
                doTake(amount);
            } else {
                throw new IllegalArgumentException("Сумма снятия должна быть положительной");
            }
        }

        protected void doTake(double amount) {
            if (amount <= balance) {
                balance -= amount;
            } else {
                throw new IllegalArgumentException("Недостаточно средств на счете");
            }
        }

        @Override
        public double getAmount() {
            return balance;
        }
    }

    public static class FixedAmountAccount implements Account {
        private double fixedAmount;

        public FixedAmountAccount(double fixedAmount) {
            this.fixedAmount = fixedAmount;
        }

        @Override
        public double getAmount() {
            return fixedAmount;
        }

        @Override
        public void put(double amount) {
            // Не изменяет баланс
        }

        @Override
        public void take(double amount) {
            // Не изменяет баланс
        }
    }

    public static void main(String[] args) {
        Account account = new AbstractAccount(1000) {
            @Override
            protected void doTake(double amount) {
                // Снятие со счета с комиссией 1%
                super.doTake(amount * 1.01);
            }
        };

        account.put(1000);
        account.take(200);
        System.out.println("Account balance: " + account.getAmount());

        Account fixedAccount = new FixedAmountAccount(500);
        fixedAccount.take(200);
        System.out.println("Fixed account balance: " + fixedAccount.getAmount());
    }
}
