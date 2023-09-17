package cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n02.model.domain;

import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class FlorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk_FlorID;
    private String nombreFlor;
    private String paisFlor;
	
    public FlorEntity(Integer pk_FlorID, String nombreFlor, String paisFlor) {
		super();
		this.pk_FlorID = pk_FlorID;
		this.nombreFlor = nombreFlor;
		this.paisFlor = paisFlor;
	}

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