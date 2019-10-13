import java.util.ArrayList;

/**
 * Klassen Bank har värden för ränta och transaktionsavgift.
 * Klassen har metod som räknar ut ränta för kunden.
 */
public class Bank {


    private double interestRate = 8.5;
    private double transactionFees = 10;
    Customer[] customers = new Customer[1000];

    /**
     * Metoden räknar ut hur mycket ränta i pengar via den satta räntekursen en specefik kund kommer att få i framtiden.
     *
     * @param customer Tar mot customer objekt
     */
    public void calculateInterest(Customer customer) {

        Account a = customer.getAccount();
        double bal = a.getBalance();
        double interestAmount = bal * interestRate / 100;
        double totalBalance = bal + interestAmount;
        System.out.println("Interest amount: " + interestAmount + ", Total money after adding interest: " + totalBalance);

    }

    public double getTransactionFees() {
        return transactionFees;
    }

    public Customer[] getCustomer() {
        return customers;
    }

}
