/**
 * I Superklassen bankOffice har vi namnet på banken och clearingnumret en kund tillhör i.
 */
public class BankOffice {


    private String bankName;
    private String bankClearing;

    /**
     * Konstruktorn BankOffice tar emot parametrar banknamn och clearingnr.
     *
     * @param bankName     banknamn
     * @param bankClearing clearingnummer.
     */
    BankOffice(String bankName, String bankClearing) {
        this.bankName = bankName;
        this.bankClearing = bankClearing;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankClearing() {
        return bankClearing;
    }
}
