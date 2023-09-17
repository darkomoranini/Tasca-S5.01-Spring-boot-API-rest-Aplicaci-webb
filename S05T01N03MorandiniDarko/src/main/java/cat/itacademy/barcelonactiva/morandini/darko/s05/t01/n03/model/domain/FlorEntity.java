package cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n03.model.domain;

public class FlorEntity {
	
    private Integer pk_FlorID;
    private String nombreFlor;
    private String paisFlor;

	public Integer getPk_FlorID() {
		return pk_FlorID;
	}

	public void setPk_FlorID(Integer pk_FlorID) {
		this.pk_FlorID = pk_FlorID;
	}

	public String getNombreFlor() {
		return nombreFlor;
	}

	public void setNombreFlor(String nombreFlor) {
		this.nombreFlor = nombreFlor;
	}

	public String getPaisFlor() {
		return paisFlor;
	}

	public void setPaisFlor(String paisFlor) {
		this.paisFlor = paisFlor;
	}
}
