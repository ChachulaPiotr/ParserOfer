package Oferteo;

import java.util.List;

public class OSpecjaliscie {
	private String opis;
	private List<String> branza;
	private List<String> obszarDzialania;
	private List<String> weryfikacjaOferteo;

	public OSpecjaliscie(String opis, List<String> branza, List<String> obszarDzialania, List<String> weryfikacjaOferteo) {
		this.opis = opis;
		this.branza = branza;
		this.obszarDzialania = obszarDzialania;
		this.weryfikacjaOferteo = weryfikacjaOferteo;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<String> getBranza() {
		return branza;
	}

	public void setBranza(List<String> branza) {
		this.branza = branza;
	}

	public List<String> getObszarDzialania() {
		return obszarDzialania;
	}

	public void setObszarDzialania(List<String> obszarDzialania) {
		this.obszarDzialania = obszarDzialania;
	}

	public List<String> getWeryfikacjaOferteo() {
		return weryfikacjaOferteo;
	}

	public void setWeryfikacjaOferteo(List<String> weryfikacjaOferteo) {
		this.weryfikacjaOferteo = weryfikacjaOferteo;
	}

	@Override
	public String toString() {
		return "OSpecjaliscie{" +
				"opis=" + opis +
				", branza=" + branza +
				", obszarDzialania=" + obszarDzialania +
				", weryfikacjaOferteo=" + weryfikacjaOferteo +
				'}';
	}
}
