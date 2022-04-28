package br.unitins.unimacy.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unimacy.application.Util;
import br.unitins.unimacy.exception.RepositoryException;
import br.unitins.unimacy.model.Fornecedor;
import br.unitins.unimacy.repository.FornecedorRepository;

@Named
@ViewScoped
public class FornecedorListing extends Listing<Fornecedor> {

	private static final long serialVersionUID = 5585881462741169448L;
	
	private String filtro;

	public FornecedorListing() {
		super("fornecedorlisting", new FornecedorRepository());
	}

	@Override
	public void pesquisar() {
		FornecedorRepository repo = new FornecedorRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage("Problema ao realizar a consulta.");
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
	@Override
	public void open() {
		// TODO Auto-generated method stub
		super.open();
	}

}
