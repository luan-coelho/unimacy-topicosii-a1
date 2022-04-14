package br.unitins.unimacy.controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;

import com.gtbr.exception.ViaCepException;
import com.gtbr.exception.ViaCepFormatException;

import br.unitins.unimacy.application.ApiCep;
import br.unitins.unimacy.application.Session;
import br.unitins.unimacy.application.Util;
import br.unitins.unimacy.model.Cidade;
import br.unitins.unimacy.model.Cliente;
import br.unitins.unimacy.model.Endereco;
import br.unitins.unimacy.model.Estado;
import br.unitins.unimacy.model.PessoaFisica;
import br.unitins.unimacy.model.PessoaJuridica;
import br.unitins.unimacy.model.Sexo;
import br.unitins.unimacy.repository.ClienteRepository;

@Named
@ViewScoped
public class ClienteController extends Controller<Cliente> {

	private static final long serialVersionUID = -2587172429280470098L;

	private boolean pular;
	private boolean isPessoaJuridica;

	private List<Cliente> listaCliente;

	public ClienteController() {
		super(new ClienteRepository());
	}

	@Override
	public Cliente getEntity() {
		if (entity == null) {
			entity = new Cliente();
			if (isPessoaJuridica) {
				entity.setPessoa(new PessoaJuridica());
			} else {
				entity.setPessoa(new PessoaFisica());
			}

			entity.setEndereco(new Endereco(new Cidade(new Estado())));
		}

		return entity;
	}

	public Sexo[] getListaSexo() {
		return Sexo.values();
	}

	public boolean getPessoaJuridica() {
		return isPessoaJuridica;
	}

	public void setPessoaJuridica(boolean isPessoaJuridica) {
		this.isPessoaJuridica = isPessoaJuridica;
	}

	public boolean isPular() {
		return pular;
	}

	public void setPular(boolean pular) {
		this.pular = pular;
	}

	public String onFlowProcess(FlowEvent event) {
		if (pular) {
			pular = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public List<Cliente> getListaCliente() {
		if (listaCliente == null) {
			listaCliente = Cliente.cargaCliente();
		}
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	@Override
	public void limpar() {
		super.limpar();
	}

	public void buscarCep() {
		try {
			entity.setEndereco(ApiCep.findCep(entity.getEndereco().getCep()));
		} catch (ViaCepException e) {
			Util.addErrorMessage("Informe um CEP válido");
		} catch (ViaCepFormatException e) {
			Util.addErrorMessage("CEP com formato inválido");
		} catch (Exception e) {
			Util.addErrorMessage("Falha ao buscar CEP. Digite os dados");
		}

	}

	public void onItemSelect() {
		String nomeEstado = entity.getEndereco().getCidade().getEstado().getNome();

		Session.getInstance().set("nome-estado", nomeEstado);
	}

	public void alterar(Cliente cliente) {
		entity = cliente;

		System.out.println(entity);
		// super.alterar();
	}

	public void cadastrar() {
		incluir();

		System.out.println(entity.toString());
	}

}
