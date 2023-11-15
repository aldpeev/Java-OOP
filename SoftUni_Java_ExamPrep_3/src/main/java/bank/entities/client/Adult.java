package bank.entities.client;

public class Adult extends BaseClient{

    private final static int INTEREST_RATE = 4;

    public Adult(String name, String ID, double income) {
        super(name, ID, INTEREST_RATE, income);
    }

    @Override
    public void increase() {
        setInterest(getInterest() + 2);
    }
}
