package Oferteo;

import java.util.List;

public class SubPKD {
    private String kodPKD;
    private String nazwa;

    public SubPKD(String kodPKD, String nazwa) {
        this.kodPKD = kodPKD;
        this.nazwa = nazwa;
    }

    public String getKodPKD() {
        return kodPKD;
    }

    public void setKodPKD(String kodPKD) {
        this.kodPKD = kodPKD;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "SubPKD{" +
                "kodPKD=" + kodPKD +
                ", nazwa=" + nazwa +
                '}';
    }
}
