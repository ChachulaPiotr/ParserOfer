package Oferteo;

public class Kontakt {
    private String adres;
    private String nip;
    private String www;
    private String telefon;
    private String osobaKontaktowa;

    public Kontakt(String adres, String nip, String www, String telefon, String osobaKontaktowa) {
        this.adres = adres;
        this.nip = nip;
        this.www = www;
        this.telefon = telefon;
        this.osobaKontaktowa = osobaKontaktowa;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getOsobaKontaktowa() {
        return osobaKontaktowa;
    }

    public void setOsobaKontaktowa(String osobaKontaktowa) {
        this.osobaKontaktowa = osobaKontaktowa;
    }

    @Override
    public String toString() {
        return "Kontakt{" +
                "adres=" + adres +
                ", nip=" + nip +
                ", www=" + www +
                ", telefon=" + telefon +
                ", osobaKontaktowa=" + osobaKontaktowa +
                '}';
    }
}
