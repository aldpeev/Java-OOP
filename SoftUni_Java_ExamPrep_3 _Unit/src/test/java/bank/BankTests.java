package bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTests {
    private Bank bank;
    private Client client;

    private final static String BANK_NAME = "Pesho-Bank";
    private final static int CAPACITY = 2;
    private final static String CLIENT_NAME = "Pesho";


    @Before
    public void setUp() {
        bank = new Bank(BANK_NAME, CAPACITY);
        client = new Client(CLIENT_NAME);
    }

    @Test
    public void testConst() {
        assertEquals(BANK_NAME, bank.getName());
        assertEquals(CAPACITY, bank.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testConstThrow1() {
        bank = new Bank("", CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstThrow2() {
        bank = new Bank(BANK_NAME, -1);
    }

    @Test
    public void testAdd() {
        bank.addClient(client);

        assertEquals(1, bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrows() {
        bank.addClient(client);
        bank.addClient(client);
        bank.addClient(client);
    }

    @Test
    public void testRemove() {
        bank.addClient(client);

        bank.removeClient(CLIENT_NAME);

        assertEquals(0, bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveThrows() {
        bank.removeClient("Mesho");
    }

    @Test
    public void testWithdraw() {
        bank.addClient(client);

        bank.loanWithdrawal(CLIENT_NAME);

        assertFalse(client.isApprovedForLoan());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawThrows() {
        bank.loanWithdrawal(CLIENT_NAME);
    }


}
