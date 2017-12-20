package Oferteo;

import java.util.Iterator;
import java.util.List;

public class Opinie {
    private List<SubOpinia> opinia;

    public Opinie(List<SubOpinia> opinia) {
        this.opinia = opinia;
    }

    public List<SubOpinia> getOpinia() {

        return opinia;
    }

    public void setOpinia(List<SubOpinia> opinia) {
        this.opinia = opinia;
    }

    @Override
    public String toString() {
        return "Opinie{" +
                "opinia=" + opinia +
                '}';
    }
}
