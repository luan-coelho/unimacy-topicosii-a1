package br.unitins.unimacy.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Estado extends DefaultEntity {
	
	private static final long serialVersionUID = 5693436511646646283L;
	
	@NotBlank
	@Size(min = 2, max = 2, message = "Informe a sigla do Estado com apenas 2 letras")
	private String uf;
	
	public Estado() {
		// TODO Auto-generated constructor stub
	}

	public Estado(String uf) {
		super();
		this.uf = uf;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
