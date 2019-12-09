package br.edu.infnet.ecommerce.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.edu.infnet.ecommerce.modelo.Carrinho;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private String nome;
	private Double preco;
	@ManyToMany(mappedBy = "produtos", fetch=FetchType.EAGER)
	List<Carrinho> carrinhos = new ArrayList<Carrinho>();
	
	public Produto() {
	}

	public Produto(String nome) {
		super();
		this.nome = nome;
	}

	public Produto(String nome, Double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	public List<Carrinho> getCarrinhos() {
		return carrinhos;
	}

	public void setCarrinhos(List<Carrinho> carrinhos) {
		this.carrinhos = carrinhos;
	}
	
	public void addCarrinho(Carrinho carrinho) {
		this.carrinhos.add(carrinho);
		carrinho.getProdutos().add(this);
	}
	
	public void removeCarrinho(Carrinho carrinho) {
		this.carrinhos.remove(carrinho);
		carrinho.getProdutos().remove(this);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
	}				
}
