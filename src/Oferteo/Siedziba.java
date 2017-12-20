package Oferteo;

public class Siedziba {
    private String kraj;
    private String wojewodztwo;
    private String powiat;
    private String gmina;
    private String miejscowosc;
    private String kodPocztowy;
    private String poczta;
    private String ulica;
    private String numerNieruchomosci;

    public Siedziba(String kraj, String wojewodztwo, String powiat, String gmina, String miejscowosc, String kodPocztowy, String poczta, String ulica, String numerNieruchomosci) {
        this.kraj = kraj;
        this.wojewodztwo = wojewodztwo;
        this.powiat = powiat;
        this.gmina = gmina;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.poczta = poczta;
        this.ulica = ulica;
        this.numerNieruchomosci = numerNieruchomosci;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getWojewodztwo() {
        return wojewodztwo;
    }

    public void setWojewodztwo(String wojewodztwo) {
        this.wojewodztwo = wojewodztwo;
    }

    public String getPowiat() {
        return powiat;
    }

    public void setPowiat(String powiat) {
        this.powiat = powiat;
    }

    public String getGmina() {
        return gmina;
    }

    public void setGmina(String gmina) {
        this.gmina = gmina;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getPoczta() {
        return poczta;
    }

    public void setPoczta(String poczta) {
        this.poczta = poczta;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumerNieruchomosci() {
        return numerNieruchomosci;
    }

    public void setNumerNieruchomosci(String numerNieruchomosci) {
        this.numerNieruchomosci = numerNieruchomosci;
    }

    @Override
    public String toString() {
        return "Siedziba{" +
                "kraj=" + kraj +
                ", wojewodztwo=" + wojewodztwo +
                ", powiat=" + powiat +
                ", gmina=" + gmina +
                ", miejscowosc=" + miejscowosc +
                ", kodPocztowy=" + kodPocztowy +
                ", poczta=" + poczta +
                ", ulica=" + ulica +
                ", numerNieruchomosci=" + numerNieruchomosci +
                '}';
    }
}
