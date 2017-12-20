package Oferteo;

public class Firma {
    private String nazwaFirmy;
    private String imiepierwsze;
    private String imiedrugie;
    private String nazwisko;
    private String dataRozpoczeciaDzialalnosci;
    private String nip;
    private String regon;

    public Firma(String nazwaFirmy, String imiepierwsze, String imiedrugie, String nazwisko, String dataRozpoczeciaDzialalnosci, String nip, String regon) {
        this.nazwaFirmy = nazwaFirmy;
        this.imiepierwsze = imiepierwsze;
        this.imiedrugie = imiedrugie;
        this.nazwisko = nazwisko;
        this.dataRozpoczeciaDzialalnosci = dataRozpoczeciaDzialalnosci;
        this.nip = nip;
        this.regon = regon;
    }

    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }

    public String getImiepierwsze() {
        return imiepierwsze;
    }

    public void setImiepierwsze(String imiepierwsze) {
        this.imiepierwsze = imiepierwsze;
    }

    public String getImiedrugie() {
        return imiedrugie;
    }

    public void setImiedrugie(String imiedrugie) {
        this.imiedrugie = imiedrugie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getDataRozpoczeciaDzialalnosci() {
        return dataRozpoczeciaDzialalnosci;
    }

    public void setDataRozpoczeciaDzialalnosci(String dataRozpoczeciaDzialalnosci) {
        this.dataRozpoczeciaDzialalnosci = dataRozpoczeciaDzialalnosci;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    @Override
    public String toString() {
        return "Firma{" +
                "nazwaFirmy=" + nazwaFirmy +
                ", imiepierwsze=" + imiepierwsze +
                ", imiedrugie=" + imiedrugie +
                ", nazwisko=" + nazwisko +
                ", dataRozpoczeciaDzialalnosci=" + dataRozpoczeciaDzialalnosci +
                ", nip=" + nip +
                ", regon=" + regon +
                '}';
    }
}
