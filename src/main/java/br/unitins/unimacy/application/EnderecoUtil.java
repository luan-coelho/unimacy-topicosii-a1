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
public class EnderecoUtil implements Serializable {

	private static final long serialVersionUID = -1251069270232023122L;

	private List<EstadoAux> listaEstado = ApiCep.pegarEstados();

	public List<String> completeText(String query) {
		String estadoLowerCase = query.toLowerCase();
		List<String> listaEstadoString = new ArrayList<>();

		for (EstadoAux estado : listaEstado) {
			listaEstadoString.add(estado.nome);
		}

		return listaEstadoString.stream().filter(t -> t.toLowerCase().startsWith(estadoLowerCase))
				.collect(Collectors.toList());
	}

	public List<String> noResults(String query) {
		return Collections.emptyList();
	}

	public List<EstadoAux> completeEstado(String query) {
		String queryLowerCase = query.toLowerCase();
		return listaEstado.stream().filter(t -> t.nome.toLowerCase().contains(queryLowerCase))
				.collect(Collectors.toList());
	}

	public void onItemSelect(SelectEvent<String> event) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estado selecionado", event.getObject()));
	}

	public void onEmptyMessageSelect() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empty message selected"));
	}

}
