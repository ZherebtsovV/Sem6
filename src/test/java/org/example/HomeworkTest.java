package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {

    @Test
    void testAccount1() {
        Homework.Account Account = new Homework.Account();
        Account.put(1000);

        double putAmm = Account.getAmount();
        double expAmm = 1000;

        Assertions.assertEquals(expAmm, putAmm);
    }

    @Test
    void testAccount2() {
        Homework.Account Account = new Homework.Account();
        Account.put(1000);
        Account.take(400);

        double putAmm = Account.getAmount();
        double expAmm = 600;

        Assertions.assertEquals(expAmm, putAmm);
    }

    @Test
    void testCreditAccount1() {
        Homework.CreditAccount creditAccount = new Homework.CreditAccount();
        creditAccount.put(1000);
        creditAccount.take(400);

        double putAmm = creditAccount.getAmount();
        double expAmm = 596;

        Assertions.assertEquals(expAmm, putAmm);
    }







}