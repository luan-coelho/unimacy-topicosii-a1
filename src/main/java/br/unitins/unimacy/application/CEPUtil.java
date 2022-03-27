package br.unitins.unimacy.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Objects;

import com.google.gson.Gson;
import com.gtbr.exception.ViaCepException;
import com.gtbr.exception.ViaCepFormatException;
import com.gtbr.utils.CEPUtils;

import br.unitins.unimacy.model.Cidade;
import br.unitins.unimacy.model.Endereco;
import br.unitins.unimacy.model.Estado;

public class CEPUtil {

    private static final String viaCepUrl = "https://viacep.com.br/ws/";
    private static final Gson gson = new Gson();

    public static Endereco findCep(String cepString) {
        CEPUtils.validaCep(cepString);
        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofMinutes(1L))
                    .build();

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(viaCepUrl+cepString+"/json"))
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            EnderecoAux enderecoAux = gson.fromJson(httpResponse.body(), EnderecoAux.class);
            
            System.out.println(enderecoAux);
            
            return organizarCep(enderecoAux);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

	class EnderecoAux {
		 private String cep;
		    String logradouro;
		    String bairro;
		    String localidade;
		    String uf;

		@Override
		public String toString() {
			return "EnderecoAux [cep=" + cep + ", logradouro=" + logradouro + ", bairro=" + bairro + ", localidade="
					+ localidade + ", uf=" + uf + "]";
		}

	}

	private static Endereco organizarCep(EnderecoAux aux) {
		Endereco endereco = new Endereco(new Cidade(new Estado()));

		endereco.setCep(aux.cep);
		endereco.setRua(aux.logradouro);
		endereco.setBairro(aux.bairro);
		endereco.getCidade().setNome(aux.localidade);
		endereco.getCidade().getEstado().setUf(aux.uf);

		return endereco;
	}

	public static void validaCep(String cep) {
		if (Objects.isNull(cep) || cep.isEmpty() || cep.isBlank())
			throw new ViaCepException("O cep informado não pode ser nulo ou vazio");
		if (cep.length() > 8)
			throw new ViaCepFormatException("CEP fora do formato, caso esteja com hifen, use o metodo de formatacao");
		if (cep.length() < 8)
			throw new ViaCepException("CEP faltando numeros");
	}

	public static String removeMascaraCep(String cep) {
		try {
			validaCep(cep);
			return cep;
		} catch (ViaCepFormatException e) {
			return cep.replace("-", "");
		}
	}

}
