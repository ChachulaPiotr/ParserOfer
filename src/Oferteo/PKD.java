package Oferteo;

import java.util.List;
import java.util.Map;

public class PKD {
    private List<SubPKD> pkd;

    public PKD(List<SubPKD> pkd) {
        this.pkd = pkd;
    }

    public List<SubPKD> getPkd() {
        return pkd;
    }

    public void setPkd(List<SubPKD> pkd) {
        this.pkd = pkd;
    }

    @Override
    public String toString() {
        return "PKD{" +
                "pkd=" + pkd +
                '}';
    }
}
