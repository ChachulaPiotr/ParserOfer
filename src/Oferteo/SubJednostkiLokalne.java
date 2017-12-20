package Oferteo;

public class SubJednostkiLokalne {
    private String regon;
    private String nazwa;
    private String adres;

    public SubJednostkiLokalne(String regon, String nazwa, String adres) {
        this.regon = regon;
        this.nazwa = nazwa;
        this.adres = adres;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "JednostkiLokalne{" +
                "regon=" + regon +
                ", nazwa=" + nazwa +
                ", adres=" + adres +
                '}';
    }
}
