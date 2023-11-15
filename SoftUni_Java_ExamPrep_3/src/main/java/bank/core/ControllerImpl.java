package bank.core;

import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;
import bank.repositories.LoanRepository;

import java.util.LinkedHashMap;
import java.util.Map;

public class ControllerImpl implements Controller {
    private LoanRepository loans;
    private Map<String, Bank> banks;

    public ControllerImpl() {
        loans = new LoanRepository();
        banks = new LinkedHashMap<>();
    }

    @Override
    public String addBank(String type, String name) {
        Bank bank;

        switch (type) {
            case "CentralBank":
                bank = new CentralBank(name);
                break;
            case "BranchBank":
                bank = new BranchBank(name);
                break;
            default:
                throw new IllegalArgumentException("Invalid bank type.");
        }

        banks.put(name, bank);
        return String.format("%s is successfully added.", type);
    }

    @Override
    public String addLoan(String type) {
        Loan loan;

        switch (type) {
            case "StudentLoan":
                loan = new StudentLoan();
                break;
            case "MortgageLoan":
                loan = new MortgageLoan();
                break;
            default:
                throw new IllegalArgumentException("Invalid loan type.");
        }

        loans.addLoan(loan);

        return String.format("%s is successfully added.", type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Loan loan = loans.findFirst(loanType);

        if (loan == null){
            throw new IllegalArgumentException(String.format("Loan of type %s is missing.", loanType));
        }

        Bank bank = banks.get(bankName);
        bank.addLoan(loan);
        loans.removeLoan(loan);

        return String.format("%s successfully added to %s.", loanType, bankName);
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {

        Client client;
        String typeClient;

        switch (clientType){
            case "Student":
                client = new Student(clientName,clientID,income);
                typeClient = "Student";
                break;
            case "Adult":
                client = new Adult(clientName,clientID,income);
                typeClient = "Adult";
                break;
            default:
                throw new IllegalArgumentException("Invalid client type.");
        }

        Bank bank = banks.get(bankName);
        String bankType = bank.getClass().getSimpleName();

        String out;

        if (bankType.equals("CentralBank") && typeClient.equals("Adult") || bankType.equals("BranchBank") && typeClient.equals("Student") ){
            bank.addClient(client);
            out = String.format("%s successfully added to %s.", clientType, bankName);
        } else {
            out = "Unsuitable bank.";
        }

        return out;
    }

    @Override
    public String finalCalculation(String bankName) {
        Bank bank = banks.get(bankName);

        double sum = 0;

        for (Client client : bank.getClients()) {
            sum += client.getIncome();
        }

        for (Loan loan : bank.getLoans()) {
            sum += loan.getAmount();
        }

        return String.format("The funds of bank %s is %.2f.", bankName, sum);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        for (Bank bank : banks.values()) {
            sb.append(bank.getStatistics());
        }
        return sb.toString();
    }
}
