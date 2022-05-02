package br.unitins.unimacy.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
public class Produto extends DefaultEntity {

	private static final long serialVersionUID = 8466588015114273678L;

	@NotBlank(message = "Informe o nome")
	private String nome;
	private String descricao;
	
	@NotNull(message = "Informe a quantidade em estoque")
	private Integer quantEstoque;
	
	@NotNull(message = "Informe o preço unitário")
	private BigDecimal preco;
	
	@NotNull(message = "Informe o peso")
	private Double peso;
	
	@NotNull(message = "Informe a data de validade")
	private LocalDate validade;
	
	@NotNull(message = "Informe a data de fabricação")
	@Past(message = "Informe uma data de fabricação anterior ao dia de hoje")
	private LocalDate fabricacao;
	
	@NotBlank(message = "Informe o lote")
	private String lote;

	@NotNull(message = "Informe a categoria")
	@ManyToOne
	private Categoria categoria;

	@NotNull(message = "Informe a unidade")
	@ManyToOne(cascade = CascadeType.ALL)
	private Unidade unidade;

	@NotNull(message = "Selecione o fornecedor")
	@ManyToOne
	private Fornecedor fornecedor;

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(String nome, String descricao, Integer quantEstoque, BigDecimal preco, Double peso,
			LocalDate validade, LocalDate fabricacao, String lote, Categoria categoria, Unidade unidade,
			Fornecedor fornecedor) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.quantEstoque = quantEstoque;
		this.preco = preco;
		this.peso = peso;
		this.validade = validade;
		this.fabricacao = fabricacao;
		this.lote = lote;
		this.categoria = categoria;
		this.unidade = unidade;
		this.fornecedor = fornecedor;
	}

	public Produto(Categoria categoria) {
		super();
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantEstoque() {
		return quantEstoque;
	}

	public void setQuantEstoque(Integer quantEstoque) {
		this.quantEstoque = quantEstoque;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public LocalDate getFabricacao() {
		return fabricacao;
	}

	public void setFabricacao(LocalDate fabricacao) {
		this.fabricacao = fabricacao;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Unidade getUnidade() {
		if (unidade == null) {
			unidade = new Unidade();
		}
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", descricao=" + descricao + ", quantEstoque=" + quantEstoque + ", preco="
				+ preco + ", peso=" + peso + ", validade=" + validade + ", fabricacao=" + fabricacao + ", lote=" + lote
				+ ", categoria=" + categoria + ", unidade=" + unidade + ", fornecedor=" + fornecedor + "]";
	}

}
