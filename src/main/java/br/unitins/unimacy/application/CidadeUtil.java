package br.unitins.unimacy.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

@Named
@ViewScoped
public class CidadeUtil implements Serializable {

	private static final long serialVersionUID = -1251069270232023122L;

	private List<CidadeAux> listaCidade = ApiCep.pegarCidadePorUf("TO");

	public List<String> completeText(String query) {
		String CidadeLowerCase = query.toLowerCase();
		List<String> listaCidadeString = new ArrayList<>();

		for (CidadeAux Cidade : listaCidade) {
			listaCidadeString.add(Cidade.nome);
		}

		return listaCidadeString.stream().filter(t -> t.toLowerCase().startsWith(CidadeLowerCase))
				.collect(Collectors.toList());
	}

	public List<String> noResults(String query) {
		return Collections.emptyList();
	}

	public List<CidadeAux> completeCidade(String query) {
		String queryLowerCase = query.toLowerCase();
		return listaCidade.stream().filter(t -> t.nome.toLowerCase().contains(queryLowerCase))
				.collect(Collectors.toList());
	}

	public void onItemSelect(SelectEvent<String> event) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cidade selecionado", event.getObject()));
	}

	public void onEmptyMessageSelect() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empty message selected"));
	}

}
