package Oferteo;

public class DaneRejestrowe {
    private Firma firma;
    private Siedziba siedziba;
    private FormaPrawna formaPrawna;
    private Rejestracja rejestracja;
    private PKD pkd;
    private JednostkiLokalne jednostkiLokalne;

    public DaneRejestrowe(Firma firma, Siedziba siedziba, FormaPrawna formaPrawna, Rejestracja rejestracja, PKD pkd, JednostkiLokalne jednostkiLokalne) {
        this.firma = firma;
        this.siedziba = siedziba;
        this.formaPrawna = formaPrawna;
        this.rejestracja = rejestracja;
        this.pkd = pkd;
        this.jednostkiLokalne = jednostkiLokalne;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public Siedziba getSiedziba() {
        return siedziba;
    }

    public void setSiedziba(Siedziba siedziba) {
        this.siedziba = siedziba;
    }

    public FormaPrawna getFormaPrawna() {
        return formaPrawna;
    }

    public void setFormaPrawna(FormaPrawna formaPrawna) {
        this.formaPrawna = formaPrawna;
    }

    public Rejestracja getRejestracja() {
        return rejestracja;
    }

    public void setRejestracja(Rejestracja rejestracja) {
        this.rejestracja = rejestracja;
    }

    public PKD getPkd() {
        return pkd;
    }

    public void setPkd(PKD pkd) {
        this.pkd = pkd;
    }

    public JednostkiLokalne getJednostkiLokalne() {
        return jednostkiLokalne;
    }

    public void setJednostkiLokalne(JednostkiLokalne jednostkiLokalne) {
        this.jednostkiLokalne = jednostkiLokalne;
    }
}
