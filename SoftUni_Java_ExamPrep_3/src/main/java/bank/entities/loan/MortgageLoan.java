package bank.entities.loan;

public class MortgageLoan extends BaseLoan{

    private final static int INTEREST_RATE = 3;
    private final static double AMOUNT= 50000;

    public MortgageLoan() {
        super(INTEREST_RATE, AMOUNT);
    }
}
