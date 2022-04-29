package br.unitins.unimacy.controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.gtbr.exception.ViaCepException;
import com.gtbr.exception.ViaCepFormatException;

import br.unitins.unimacy.application.ApiCep;
import br.unitins.unimacy.application.Session;
import br.unitins.unimacy.application.Util;
import br.unitins.unimacy.exception.RepositoryException;
import br.unitins.unimacy.model.Cidade;
import br.unitins.unimacy.model.Cliente;
import br.unitins.unimacy.model.Endereco;
import br.unitins.unimacy.model.Estado;
import br.unitins.unimacy.model.PessoaFisica;
import br.unitins.unimacy.model.Sexo;
import br.unitins.unimacy.repository.ClienteRepository;

@Named
@ViewScoped
public class ClientePfController extends Controller<Cliente> {

	private static final long serialVersionUID = -2587172429280470098L;

	private List<Cliente> listaCliente;

	public ClientePfController() {
		super(new ClienteRepository());
	}

	@Override
	public Cliente getEntity() {
		if (entity == null) {
			entity = new Cliente();
			entity.setPessoa(new PessoaFisica());
			entity.getPessoa().setEndereco(new Endereco(new Cidade(new Estado())));
		}

		return entity;
	}

	public Sexo[] getListaSexo() {
		return Sexo.values();
	}

	public List<Cliente> getListaCliente() {
		if (listaCliente == null) {
			try {
				listaCliente = getRepository().findAll()
						.stream()
						.filter(cliente -> cliente.getPessoa() instanceof PessoaFisica).toList();
			} catch (RepositoryException e) {
				Util.addErrorMessage("Falha ao buscar os dados no banco");
				e.printStackTrace();
			}
		}
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	@Override
	public void limpar() {
		super.limpar();
		listaCliente = null;
	}
	
	public void excluir(Cliente cliente) {
		entity = cliente;
		super.excluir();
	}

	public void buscarCep() {
		try {
			entity.getPessoa().setEndereco(ApiCep.findCep(entity.getPessoa().getEndereco().getCep()));
		} catch (ViaCepException e) {
			Util.addErrorMessage("Informe um CEP válido");
		} catch (ViaCepFormatException e) {
			Util.addErrorMessage("CEP com formato inválido");
		} catch (Exception e) {
			Util.addErrorMessage("Falha ao buscar CEP. Digite os dados");
		}

	}

	public void onItemSelect() {
		String nomeEstado = entity.getPessoa().getEndereco().getCidade().getEstado().getNome();
		Session.getInstance().set("nome-estado", nomeEstado);
	}

	public void pesquisarPorNome(String nome) {
		try {
			getRepository().findByNome(nome);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}
	
	public void cpfExiste() {
		PessoaFisica pessoa = (PessoaFisica) entity.getPessoa();
		Cliente cliente = ((ClienteRepository) getRepository()).findByCpf(pessoa.getCpf());
		
		if(cliente != null) {
			Util.addErrorMessage("Já existe um cliente cadastrado com esse CPF");
		}
	}
}
