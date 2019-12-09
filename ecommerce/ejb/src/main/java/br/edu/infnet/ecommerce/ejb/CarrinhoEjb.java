package br.edu.infnet.ecommerce.ejb;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.infnet.ecommerce.modelo.Produto;
import br.edu.infnet.ecommerce.modelo.Carrinho;

@Stateful
@StatefulTimeout(unit=TimeUnit.MINUTES, value=30)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CarrinhoEjb {
	
	@PersistenceContext(unitName = "br.edu.infnet.ecommerce")
	private EntityManager em;
	
	private Map<Integer, Produto> repo = new TreeMap<Integer, Produto>();

	public Produto addProd(Integer id, Produto produto) {
		repo.put(id, produto);
		return produto;
	}
	public void delProd(Integer id) {
		repo.remove(id);
	}
	public List<Produto> listarProd(){
		return repo.values().stream().collect(Collectors.toList());
	}
	
	public Carrinho guardar(Carrinho carrinho) {		
		try {
			em.clear();
			em.persist(carrinho);
			em.flush();
			return carrinho;
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Carrinho> listar() {	
		return em.createQuery("SELECT c FROM Carrinho c").getResultList();
	}
	
	public void pagar(Carrinho carrinho) {
		try {			
			em.clear();
			em.merge(carrinho);
			em.flush();						
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
