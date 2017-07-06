package com.phpdaddy.expenseregister;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpensesDaoImpl implements ExpensesDao {
    protected List<Expense> expenses;
    protected String file = "t.tmp";

    public ExpensesDaoImpl(String fileName) {
        this.file = fileName;
        populateExpenses();
    }

    public ExpensesDaoImpl(String fileName, List<Expense> data) {
        this.file = fileName;
        this.expenses = data;
    }

    public List<Expense> findAll() {
        return expenses;
    }

    public void save(Expense expense) throws IOException {
        expenses.add(expense);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(expenses);
        oos.close();
    }

    @Override
    public int calcSum(final Date startDate, final Date endDate) {
        return expenses.stream().filter(expense -> (expense.getDate().after(startDate) && expense.getDate().before(endDate)) || expense.getDate().equals(startDate))
                .mapToInt(expense -> expense.getAmount()).sum();
    }

    @Override
    public double calcAverage(Date startDate, Date endDate) {
        return expenses.stream().filter(expense -> (expense.getDate().after(startDate) && expense.getDate().before(endDate)) || expense.getDate().equals(startDate))
                .mapToInt(expense -> expense.getAmount()).average().getAsDouble();
    }

    @Override
    public void cleanAll() throws IOException {
        this.expenses.clear();
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(new ArrayList<Expense>());
        oos.close();
    }

    private List<Expense> readFile(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        expenses = (List<Expense>) ois.readObject();
        ois.close();
        return expenses;
    }

    private void populateExpenses() {
        try {
            expenses = this.readFile(file);
        } catch (Exception ex) {
            expenses = new ArrayList<>();
        }
    }
}
