package Oferteo;

public class SubOpinia {
    private String opinia;
    private String ocena;
    private String data;

    public SubOpinia() {
    }

    public SubOpinia(String opinia, String ocena, String data) {
        this.opinia = opinia;
        this.ocena = ocena;
        this.data = data;
    }

    public String getOpinia() {
        return opinia;
    }

    public void setOpinia(String opinia) {
        this.opinia = opinia;
    }

    public String getOcena() {
        return ocena;
    }

    public void setOcena(String ocena) {
        this.ocena = ocena;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SubOpinia{" +
                "opinia='" + opinia + '\'' +
                ", ocena=" + ocena +
                ", data='" + data + '\'' +
                '}';
    }
}
