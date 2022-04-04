package br.unitins.unimacy.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.google.gson.Gson;
import com.gtbr.exception.ViaCepException;
import com.gtbr.exception.ViaCepFormatException;
import com.gtbr.utils.CEPUtils;

import br.unitins.unimacy.model.Cidade;
import br.unitins.unimacy.model.Endereco;
import br.unitins.unimacy.model.Estado;

class EnderecoAux {
	String cep;
	String logradouro;
	String bairro;
	String localidade;
	String uf;
}

class EstadoAux {
	String nome;
	String sigla;
}

class CidadeAux {
	String nome;
}

public class ApiCep {

	private static final String viaCepUrl = "https://viacep.com.br/ws/";
	private static final Gson gson = new Gson();

	public static Endereco findCep(String cepString) {
		CEPUtils.validaCep(cepString);
		try {
			HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofMinutes(1L)).build();

			HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri(URI.create(viaCepUrl + cepString + "/json"))
					.build();

			HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			
			 EnderecoAux enderecoAux = gson.fromJson(httpResponse.body(), EnderecoAux.class);
			 
			 return organizarCep(enderecoAux, pegarEstadoPorUf(enderecoAux.uf));	

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	

	private static Endereco organizarCep(EnderecoAux enderecoAux, EstadoAux estadoAux) {
		Endereco endereco = new Endereco(new Cidade(new Estado()));

		endereco.setCep(enderecoAux.cep);
		endereco.setRua(enderecoAux.logradouro);
		endereco.setBairro(enderecoAux.bairro);
		
		endereco.getCidade().setNome(enderecoAux.localidade);
		endereco.getCidade().getEstado().setNome(estadoAux.nome);
		endereco.getCidade().getEstado().setUf(enderecoAux.uf);

		return endereco;
	}

	public static void validaCep(String cep) {
		if (Objects.isNull(cep) || cep.isEmpty() || cep.isBlank())
			throw new ViaCepException(null);
		if (cep.length() > 8)
			throw new ViaCepFormatException(null);
		if (cep.length() < 8)
			throw new ViaCepException(null);
	}

	public static String removeMascaraCep(String cep) {
		try {
			validaCep(cep);
			return cep;
		} catch (ViaCepFormatException e) {
			return cep.replace("-", "");
		}
	}
	
	private static EstadoAux pegarEstadoPorUf(String uf) {
		try {
			HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofMinutes(1L)).build();

			final String SERVICE_IBGE = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/";
			
			HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri(URI.create(SERVICE_IBGE + uf))
					.build();

			HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

			return gson.fromJson(httpResponse.body(), EstadoAux.class);

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static List <EstadoAux> pegarEstados() {
		try {
			HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofMinutes(1L)).build();

			final String SERVICE_IBGE = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";
			
			HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri(URI.create(SERVICE_IBGE))
					.build();

			HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			
			System.out.println(httpResponse.body().toString());

			
			EstadoAux estados[] = gson.fromJson(httpResponse.body(), EstadoAux[].class);

			return Arrays.asList(estados);

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static List <CidadeAux> pegarCidadePorUf(String uf) {
		try {
			HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofMinutes(1L)).build();

			final String SERVICE_IBGE = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/"+uf+"/distritos";
			
			HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri(URI.create(SERVICE_IBGE))
					.build();

			HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			
			System.out.println(httpResponse.body().toString());

			CidadeAux cidades[] = gson.fromJson(httpResponse.body(), CidadeAux[].class);

			return Arrays.asList(cidades);

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

}
