package Oferteo;

public class FormaPrawna {
    private String podstawowaFormaPrawna;
    private String szczegolowaFormaPrawna;
    private String formaWlasnosci;

    public FormaPrawna(String podstawowaFormaPrawna, String szczegolowaFormaPrawna, String formaWlasnosci) {
        this.podstawowaFormaPrawna = podstawowaFormaPrawna;
        this.szczegolowaFormaPrawna = szczegolowaFormaPrawna;
        this.formaWlasnosci = formaWlasnosci;
    }

    public String getPodstawowaFormaPrawna() {
        return podstawowaFormaPrawna;
    }

    public void setPodstawowaFormaPrawna(String podstawowaFormaPrawna) {
        this.podstawowaFormaPrawna = podstawowaFormaPrawna;
    }

    public String getSzczegolowaFormaPrawna() {
        return szczegolowaFormaPrawna;
    }

    public void setSzczegolowaFormaPrawna(String szczegolowaFormaPrawna) {
        this.szczegolowaFormaPrawna = szczegolowaFormaPrawna;
    }

    public String getFormaWlasnosci() {
        return formaWlasnosci;
    }

    public void setFormaWlasnosci(String formaWlasnosci) {
        this.formaWlasnosci = formaWlasnosci;
    }

    @Override
    public String toString() {
        return "FormaPrawna{" +
                "podstawowaFormaPrawna=" + podstawowaFormaPrawna +
                ", szczegolowaFormaPrawna=" + szczegolowaFormaPrawna +
                ", formaWlasnosci=" + formaWlasnosci +
                '}';
    }
}
