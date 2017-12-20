package Oferteo;

public class Rejestracja {
    private String dataWpisuRegon;
    private String dataPowstania;
    private String dataRozpoczeciaDzialalnosci;

    public Rejestracja(String dataWpisuRegon, String dataPowstania, String dataRozpoczeciaDzialalnosci) {
        this.dataWpisuRegon = dataWpisuRegon;
        this.dataPowstania = dataPowstania;
        this.dataRozpoczeciaDzialalnosci = dataRozpoczeciaDzialalnosci;
    }

    public String getDataWpisuRegon() {
        return dataWpisuRegon;
    }

    public void setDataWpisuRegon(String dataWpisuRegon) {
        this.dataWpisuRegon = dataWpisuRegon;
    }

    public String getDataPowstania() {
        return dataPowstania;
    }

    public void setDataPowstania(String dataPowstania) {
        this.dataPowstania = dataPowstania;
    }

    public String getDataRozpoczeciaDzialalnosci() {
        return dataRozpoczeciaDzialalnosci;
    }

    public void setDataRozpoczeciaDzialalnosci(String dataRozpoczeciaDzialalnosci) {
        this.dataRozpoczeciaDzialalnosci = dataRozpoczeciaDzialalnosci;
    }

    @Override
    public String toString() {
        return "Rejestracja{" +
                "dataWpisuRegon=" + dataWpisuRegon +
                ", dataPowstania=" + dataPowstania +
                ", dataRozpoczeciaDzialalnosci=" + dataRozpoczeciaDzialalnosci +
                '}';
    }
}
