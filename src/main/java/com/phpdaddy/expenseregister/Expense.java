package com.phpdaddy.expenseregister;

import java.io.Serializable;
import java.util.Date;

public class Expense implements Serializable {
    private int amount;
    private Date date;

    public Expense() {

    }

    public Expense(int amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        if (amount != expense.amount) return false;
        return date != null ? date.equals(expense.date) : expense.date == null;
    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
