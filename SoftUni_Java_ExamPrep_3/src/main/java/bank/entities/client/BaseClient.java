package bank.entities.client;

public abstract class BaseClient implements Client{
    private String name;
    private String ID;
    private int interest;
    private double income;

    protected BaseClient(String name, String ID, int interest, double income) {
        setName(name);
        setID(ID);
        setInterest(interest);
        setIncome(income);
    }

    private void setID(String ID) {
        if (ID == null || ID.trim().isEmpty()){
            throw new IllegalArgumentException("Client’s ID cannot be null or empty.");
        }
        this.ID = ID;
    }

    protected void setInterest(int interest) {
        this.interest = interest;
    }

    private void setIncome(double income) {
        if (income <= 0){
            throw new IllegalArgumentException("Client income cannot be below or equal to 0.");
        }
        this.income = income;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Client name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getInterest() {
        return interest;
    }

    @Override
    public double getIncome() {
        return income;
    }

}
