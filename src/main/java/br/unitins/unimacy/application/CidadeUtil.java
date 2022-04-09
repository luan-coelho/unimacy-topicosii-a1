package br.unitins.unimacy.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unimacy.model.Cidade;

@Named
@ViewScoped
public class CidadeUtil implements Serializable {

	private static final long serialVersionUID = -629188925555279475L;

	private String ufEstado;

	private List<Cidade> listaCidade;

	public CidadeUtil() {
		this.ufEstado = (String) Session.getInstance().get("uf-estado");
	}

	public String getUfEstado() {
		return ufEstado;
	}

	public List<Cidade> getListaCidade() {
		if (listaCidade == null) {
			this.listaCidade = ApiCep.pegarCidadePorUf(ufEstado);
			System.out.println(ufEstado);
		}
		return listaCidade;
	}

	public List<String> completeText(String query) {
		String CidadeLowerCase = query.toLowerCase();
		List<String> listaCidadeString = new ArrayList<>();

		for (Cidade Cidade : getListaCidade()) {
			listaCidadeString.add(Cidade.getNome());
		}

		return listaCidadeString.stream().filter(t -> t.toLowerCase().startsWith(CidadeLowerCase))
				.collect(Collectors.toList());
	}

	public List<String> noResults(String query) {
		return Collections.emptyList();
	}

	public List<Cidade> completeCidade(String query) {
		String queryLowerCase = query.toLowerCase();
		return listaCidade.stream().filter(t -> t.getNome().toLowerCase().contains(queryLowerCase))
				.collect(Collectors.toList());
	}
}
