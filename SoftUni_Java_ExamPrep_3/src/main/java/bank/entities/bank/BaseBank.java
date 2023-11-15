package bank.entities.bank;

import bank.entities.client.Client;
import bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseBank implements Bank {
    private String name;
    private int capacity;
    private List<Loan> loans;
    private List<Client> clients;

    public BaseBank(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        loans = new ArrayList<>();
        clients = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Bank name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public List<Client> getClients() {
        return clients;
    }

    @Override
    public List<Loan> getLoans() {
        return loans;
    }

    @Override
    public void addClient(Client client) {
        if (clients.size() >= capacity) {
            throw new IllegalArgumentException("Not enough capacity for this client.");
        }

        clients.add(client);
    }

    @Override
    public void removeClient(Client client) {
        clients.remove(client);
    }

    @Override
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    @Override
    public int sumOfInterestRates() {
        return loans.stream().mapToInt(Loan::getInterestRate).sum();
    }

    @Override
    public String getStatistics() {

//        "Name: {bankName}, Type: {bankType}
//        Clients: {clientName1}, {clientName2} ... / Clients: none
//        Loans: {loansCount}, Sum of interest rates: {sumOfInterestRates}"
//        Note: I remind you that there are two bank types – CentralBank and BranchBank.

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Name: %s, Type: %s", name, this.getClass().getSimpleName()))
                .append(System.lineSeparator());

        if (clients.isEmpty()) {
            sb.append("Clients: none");
        } else {
            sb.append(String.format("Clients: %s", clients.stream().map(Client::getName).collect(Collectors.joining(", "))));
        }

        sb.append(System.lineSeparator())
                .append(String.format("Loans: %d, Sum of interest rates: %d",loans.size(), sumOfInterestRates()))
                .append(System.lineSeparator());

        return sb.toString();
    }
}



