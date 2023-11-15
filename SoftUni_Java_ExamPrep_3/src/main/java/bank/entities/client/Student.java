package bank.entities.client;

public class Student extends BaseClient{

    private final static int INTEREST_RATE = 2;

    public Student(String name, String ID, double income) {
        super(name, ID, INTEREST_RATE, income);
    }

    @Override
    public void increase() {
        setInterest(getInterest() + 1);
    }
}
