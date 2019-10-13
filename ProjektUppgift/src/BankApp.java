import java.util.Scanner;

/**
 * I main klassen har vi menyn och switch case och objekt från klasserna.
 * I switch case lagras data som matas in av användaren och läggs till i objekten.
 * När vi uppdaterar en kund med insättning eller uttag kontrolleras först om kunden existerar, och sedan via inmatning av kontonummer, göra ändring för en specefik kund.
 * Programmet ska kunna visa saldo och kundinformation.
 * Programmet har en fast avgift för varje uttag förrutom det första.
 * Programmet skall även kunna räkna ut hur mycket ränta en kund kan få utifrån saldot.
 *
 * @author Ibrahim El-Faourie
 * @version 1.0
 * @since 2019-10-13
 */
public class BankApp {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfCustomers = 0;
        Bank bank = new Bank();
        Customer[] c = bank.getCustomer();

        while (true) {
            System.out.println("Please enter your choice:");
            System.out.println("1: Add Customer");
            System.out.println("2: Deposit Money");
            System.out.println("3: Withdraw Money");
            System.out.println("4: Check Balance");
            System.out.println("5: Calculate Interest");
            System.out.println("6: Show Customer info");
            System.out.println("7: Exit");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Creating an account for a new customer. \n");
                    System.out.println("Please enter the initial amount in your account:");
                    double bal = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("Please enter your Bank Name: ");
                    String bankName = scan.nextLine();
                    System.out.println("Please enter your Bank Clearing: ");
                    String bankClearing = scan.nextLine();
                    System.out.println("Please enter your Account Number: ");
                    String acc = scan.nextLine();
                    Account account = new Account(bal, acc);
                    System.out.println("Please enter your name: ");
                    String name = scan.nextLine();
                    Customer customer = new Customer(name, account, bankName, bankClearing);
                    c[numberOfCustomers] = customer;
                    System.out.println("Customer name: " + name + ", Was added to the bank.\n");
                    numberOfCustomers++;

                    break;

                case 2:
                    System.out.println("Enter account number: ");
                    acc = scan.nextLine();
                    if (numberOfCustomers == 0) {
                        System.err.println("Account number not found\n");
                    } else {
                        boolean found = false;
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();
                            String accTemp = temp.getAccountNumber();
                            if (accTemp.equals(acc)) {
                                System.out.println("please enter the amount to deposit: ");
                                double money = scan.nextDouble();
                                scan.nextLine();
                                temp.deposit(money);
                                found = true;
                            }
                        }
                        if (found == false) {
                            System.err.println("Account Number not found\n");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter account number: ");
                    acc = scan.nextLine();
                    if (numberOfCustomers == 0) {
                        System.err.println("Account number not found\n");
                    } else {
                        boolean found = false;
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();
                            String accTemp = temp.getAccountNumber();
                            if (accTemp.equals(acc)) {
                                System.out.println("please enter the amount to withdraw: ");
                                double money = scan.nextDouble();
                                scan.nextLine();
                                temp.withdraw(money);
                                found = true;
                            }
                        }
                        if (found == false) {
                            System.err.println("Account Number not found\n");
                        }
                    }
                    break;
                case 4:

                    System.out.println("Enter account number: ");

                    acc = scan.nextLine();
                    if (numberOfCustomers == 0) {
                        System.err.println("Account number not found\n");
                    } else {
                        boolean found = false;
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();
                            String accTemp = temp.getAccountNumber();
                            if (accTemp.equals(acc)) {
                                System.out.println("Balance is: " + temp.getBalance());

                                found = true;
                            }
                        }
                        if (found == false) {
                            System.err.println("Account Number not found\n");
                        }
                    }
                    break;
                case 5:

                    System.out.println("Enter account number: ");

                    acc = scan.nextLine();
                    if (numberOfCustomers == 0) {
                        System.err.println("Account number not found\n");
                    } else {
                        boolean found = false;
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();
                            String accTemp = temp.getAccountNumber();
                            if (accTemp.equals(acc)) {
                                bank.calculateInterest(c[i]);
                                found = true;
                            }
                        }
                        if (found == false) {
                            System.err.println("Account Number not found\n");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Enter account number: ");

                    acc = scan.nextLine();
                    if (numberOfCustomers == 0) {
                        System.err.println("Account number not found\n");
                    } else {
                        boolean found = false;
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();
                            String accTemp = temp.getAccountNumber();
                            if (accTemp.equals(acc)) {


                                System.out.println("Namn: " + c[i].getName() + "\nBank: " + c[i].getBankName() +
                                        "\nClearing nr: " + c[i].getBankClearing() + "\nAccount nr: " + c[i].getAccountNumber() +
                                        "\nBalance: " + c[i].getBalance() + "\n");

                                found = true;
                            }
                        }
                        if (found == false) {
                            System.err.println("Account Number not found\n");
                        }
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    break;

            }

        }
    }

}
