package br.unitins.unimacy.model;

public enum UnidadeMedida {
	LITRO(1), ML(2), CAIXA(3), KG(4);
	
	private int id;

	private UnidadeMedida(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public static UnidadeMedida valueOf(int id) {
		for (UnidadeMedida unidade  : UnidadeMedida.values()) {
			if (unidade.getId() == id)
				return unidade;
		}
		return null;
	}
}
