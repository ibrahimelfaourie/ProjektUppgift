/**
 * I Subklassen Customer har vi name för kundnamn och account objekt från klassen Account.
 * Vi ärver banknamn och clearingnummer från superklassen BankOffice
 */
public class Customer extends BankOffice {


    private String name;
    private Account account;

    /**
     * Konstruktorn Customer tar emot parametrar.
     *
     * @param n            parameter n för namn från name
     * @param a            parameter a för account från objekt av klassen Account. Från Account klassen får vi saldo och kontonr.
     * @param bankName     parameter bankName för namnet på banken från superklassen BankOffice
     * @param bankClearing parameter bankClearing för clearingnummer från superklassen BankOffice
     */
    Customer(String n, Account a, String bankName, String bankClearing) {
        super(bankName, bankClearing);
        name = n;
        account = a;
    }


    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    public String getAccountNumber() {
        return account.getAccountNumber();
    }

    public double getBalance() {
        return account.getBalance();
    }


}
