package org.erim.entities;

import org.erim.exceptions.AlreadyInDebtException;

public class LoanShark {
    private int debt;

    public LoanShark() {
        this.debt = 0;
    }

    public int getDebt() {
        return debt;
    }

    public void borrowMoney(int amount) {
        //TODO: maximum debt

        if(inDebt())
            throw new AlreadyInDebtException("Player has already debts");
        if(amount <= 0)
            throw new IllegalArgumentException("Amount must be greater than 0");

        this.debt += amount;
    }

    public void payBackDebt(int amount){
        if (amount <= 0)
            throw new IllegalArgumentException("amount must be greater than 0");
        //TODO: case: over paying ?

        this.debt -= amount;
    }

    public boolean inDebt(){
        return debt > 0;
    }
}
