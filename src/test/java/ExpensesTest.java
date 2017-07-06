import com.phpdaddy.expenseregister.Expense;
import com.phpdaddy.expenseregister.ExpensesDao;
import com.phpdaddy.expenseregister.ExpensesDaoImpl;
import org.junit.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class ExpensesTest {


    @Test
    public void testSum() {
        List<Expense> expenses = this.populateExpenses();
        ExpensesDaoImpl expensesDaoMock = new ExpensesDaoImpl("test.tmp", expenses);
        Date startDate = this.mockDate("January 2, 2010");
        Date endDate = this.mockDate("January 4, 2010");

        assertEquals(expensesDaoMock.calcSum(startDate, endDate), 200);
    }


    @Test
    public void testAverage() {
        List<Expense> expenses = this.populateExpenses();
        ExpensesDaoImpl expensesDaoMock = new ExpensesDaoImpl("test.tmp", expenses);

        Date startDate = this.mockDate("January 2, 2010");
        Date endDate = this.mockDate("January 4, 2010");

        assertEquals(expensesDaoMock.calcAverage(startDate, endDate), 100.0);
    }


    @Test
    public void testSave() throws Exception {
        ExpensesDaoImpl expensesDao = null;

        expensesDao = new ExpensesDaoImpl("test.tmp");

        expensesDao = new ExpensesDaoImpl("test.tmp", new ArrayList<Expense>());
        assertTrue(expensesDao.findAll().isEmpty());

        expensesDao.save(new Expense(100, this.mockDate("January 2, 2010")));
        expensesDao.save(new Expense(100, this.mockDate("January 3, 2010")));

        expensesDao = new ExpensesDaoImpl("test.tmp");




        List<Expense> facticalExpenses = expensesDao.findAll();


        List<Expense> expectedExpenses = new ArrayList<>();
        expectedExpenses.add(new Expense(100, this.mockDate("January 2, 2010")));
        expectedExpenses.add(new Expense(100, this.mockDate("January 3, 2010")));


        assertEquals(facticalExpenses, expectedExpenses);
    }

    private List<Expense> populateExpenses() {
        ArrayList<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense(100, this.mockDate("January 2, 2010")));
        expenses.add(new Expense(100, this.mockDate("January 3, 2010")));
        expenses.add(new Expense(100, this.mockDate("January 4, 2010")));
        return expenses;
    }

    private Date mockDate(String string) {
        try {
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            return format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
