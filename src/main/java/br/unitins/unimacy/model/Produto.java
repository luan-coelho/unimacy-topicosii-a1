package br.unitins.unimacy.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Produto extends DefaultEntity {

	private static final long serialVersionUID = 8466588015114273678L;

	private String nome;
	private String descricao;
	private Integer quantEstoque;
	private BigDecimal preco;
	private Double peso;
	private LocalDate validade;
	private LocalDate fabricacao;
	private String lote;
	private List<Categoria> categoria;
	private Unidade unidade;
	private Fornecedor fornecedor;

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(String nome, String descricao, Integer quantEstoque, BigDecimal preco, Double peso,
			LocalDate validade, LocalDate fabricacao, String lote, List<Categoria> categoria, Unidade unidade,
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

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	public Unidade getUnidade() {
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

}
