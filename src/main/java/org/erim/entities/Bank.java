package org.erim.entities;

public class Bank {
    private int savings;

    public Bank() {
        this.savings = 0;
    }

    public int getSavings() {
        return savings;
    }

    /**
     * Deposit some money
     * @param amount the amount to be deposited
     */
    public void deposit(int amount) {
        if(amount < 0)
            throw new IllegalArgumentException("Cannot deposit negative values ");

        this.savings += amount;
    }
}
