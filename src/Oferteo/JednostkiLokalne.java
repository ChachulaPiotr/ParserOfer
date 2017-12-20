package Oferteo;

import java.util.List;

public class JednostkiLokalne {
    private List<SubJednostkiLokalne> jednostkiLokalne;

    public JednostkiLokalne(List<SubJednostkiLokalne> jednostkiLokalne) {
        this.jednostkiLokalne = jednostkiLokalne;
    }

    public List<SubJednostkiLokalne> getJednostkiLokalne() {

        return jednostkiLokalne;
    }

    public void setJednostkiLokalne(List<SubJednostkiLokalne> jednostkiLokalne) {
        this.jednostkiLokalne = jednostkiLokalne;
    }

    @Override
    public String toString() {
        return "JednostkiLokalne{" +
                "jednostkiLokalne=" + jednostkiLokalne +
                '}';
    }
}
