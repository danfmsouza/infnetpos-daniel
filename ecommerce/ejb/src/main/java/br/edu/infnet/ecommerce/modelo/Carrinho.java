package br.edu.infnet.ecommerce.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.ecommerce.modelo.Produto;
import br.edu.infnet.ecommerce.modelo.Cliente;

@Entity
@Table(name = "carrinho")
public class Carrinho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "in_cart", joinColumns = {@JoinColumn(name = "cart_id")}, 
						  inverseJoinColumns = {@JoinColumn(name = "prod_id")})
	private List<Produto> produtos = new ArrayList<Produto>();
	private Boolean vendido;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Cliente cliente;
	
	public Carrinho() {
		
	}
	
	public Carrinho(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public Carrinho(Cliente cliente, List<Produto> produtos) {
		this.produtos = produtos;
		this.cliente = cliente;
	}
	
	public void adicionarProduto(Produto produto) {
		this.produtos.add(produto);
		produto.getCarrinhos().add(this);
	}
	
	public void removerProduto(Produto produto) {
		this.produtos.remove(produto);
		produto.getCarrinhos().remove(this);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Boolean getVendido() {
		return vendido;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}

	@Override
	public String toString() {
		return "Carrinho [id=" + id + ", produtos=" + produtos + ", vendido=" + vendido + "]";
	}
	
}
