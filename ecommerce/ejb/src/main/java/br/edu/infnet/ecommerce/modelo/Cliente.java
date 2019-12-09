package br.edu.infnet.ecommerce.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.edu.infnet.ecommerce.modelo.Carrinho;

@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String usuario;
	private String email;
	//private String senha;
	
	@OneToOne(mappedBy = "cliente", optional = true)
	private Carrinho carrinho;
	
	public Cliente() {
		
	}
	
	public Cliente(String usuario, String email) {
		this.usuario = usuario;
		this.email = email;
	}
	
	//INICIO Getters and Setters	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public String getSenha() {
//		return senha;
//	}
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
//FIM Getters and Setters

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", usuario=" + usuario + ", email=" + email + ", carrinho=" + carrinho + "]";
	}
}
