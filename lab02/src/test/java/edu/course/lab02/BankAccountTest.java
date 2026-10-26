package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void shouldWithdrawSuccessfully() {
        BankAccount account = new BankAccount(100);
        account.withdraw(30);
        assertEquals(70, account.getBalance());
    }

    @Test
    void shouldThrowExceptionWhenWithdrawingMoreThanBalance() {
        BankAccount account = new BankAccount(100);
        
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(150);
        });
        
        assertEquals(100, account.getBalance());
    }
}