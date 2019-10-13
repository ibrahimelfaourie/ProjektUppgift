/**
 * I Account klassen har vi hand om Saldo och kontonummer för den specefike kunden.
 * Klasen har metoder som utför transaktioner.
 */
public class Account {

    private double balance;
    private String accountNumber;
    private boolean firstTime = true;


    /**
     * Konstruktorn tar emot två parametrar, och vi har en if sats för att säkerställa att saldot inte understiger 100.
     * Matar användaren in minst 100 så sätts det som saldot. Annars sätts det automatiskt till 100.
     *
     * @param bal saldo.
     * @param acc kontonummer.
     */
    public Account(double bal, String acc) {
        if (bal >= 100) {
            balance = bal;
        } else {

            balance = 100;
        }
        accountNumber = acc;
    }

    /**
     * Metod för insättning av pengar till bankkontot som tar emot en parameter "howMuch" som är det användaren matar in.
     * if sats som kontrollerar att summan är positiv och större än 0, om fallet är så, kommer det plussas till på saldot.
     * else sats som ger oss ett medelande för övrig inmatning och inget händer med saldot.
     *
     * @param howMuch parametern howMuch är summan som skall läggas till på saldot.
     */

    public void deposit(double howMuch) {
        if (howMuch > 0) {
            balance = balance + howMuch;
            System.out.println(howMuch + " was successfully deposited im your account." +
                    " The new balance is : " + balance);
        } else {
            System.err.println("Please ensure the amount to deposit is not negative or 0.\n");
        }

    }

    /**
     * Metod för uttag av pengar från bankkontot som tar emot en parameter "howMuch" som är det användaren matar in.
     * Metoden har en boolean "firstTime" som kontrollerar om det är första gången ett utttag görs.
     * Metoden har if sats som via variabeln "tempBalance" ska kontrollera att summan som blir kvar i saldot är minst 100 och om fallet ej är så skall uttaget ej utföras.
     * Metoden har en else sats som ger oss ett enbart ett medelande om inmatningen är negativ eller om summan av saldot kommer understiga 100.
     * Metoden även ett värde "transactionFee" som kommer från klassen "Bank" som ska utföras vid varje uttag föruttom första gången.
     *
     * @param howMuch parameter howMuch är summan som skall tas bort från saldot
     */

    public void withdraw(double howMuch) {
        if (howMuch >= 0) {

            if (firstTime == true) {
                double tempBalance = balance;
                tempBalance = tempBalance - howMuch;
                if (tempBalance >= 100) {
                    balance = balance - howMuch;
                    System.out.println(howMuch + " was successfully withdrewed from your account." +
                            " The new balance is : " + balance + "\n");

                } else {
                    System.err.println("Insufficient balance to remove " + howMuch + "\n");
                }
                firstTime = false;

            } else {
                Bank bank = new Bank();
                double tempBalance = balance;
                tempBalance = tempBalance - howMuch - bank.getTransactionFees();
                if (tempBalance >= 100) {
                    balance = balance - howMuch - bank.getTransactionFees();
                    System.out.println("You withdrew " + howMuch + " from your account. The transaction fees is " + bank.getTransactionFees() +
                            " The new balance is : " + balance + "\n");

                } else {
                    System.err.println("Insufficient balance to remove " + howMuch + "\n");
                }
            }

        } else {

            System.err.println("Please ensure the amount to be withdrawn is not negative");
        }
    }

    public double getBalance() {

        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


}
