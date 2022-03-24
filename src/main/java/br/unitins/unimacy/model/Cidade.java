package br.unitins.unimacy.model;

public class Cidade {
	private Integer id;
	private String nome;
	private String estado;

	public Cidade() {
		// TODO Auto-generated constructor stub
	}

	public Cidade(Integer id, String nome, String estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
