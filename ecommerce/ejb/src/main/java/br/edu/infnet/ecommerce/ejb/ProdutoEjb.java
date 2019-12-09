package br.edu.infnet.ecommerce.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.edu.infnet.ecommerce.modelo.Produto;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProdutoEjb {

	@PersistenceContext(unitName = "br.edu.infnet.ecommerce")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Produto> list() {
		Query query = em.createQuery("SELECT p FROM Produto p");
	    return (List<Produto>) query.getResultList();
	}
	
	public Produto findProduto(int id) {
	    return em.find(Produto.class, id);
	}
	  
	public Produto add(Produto produto) {
		em.persist(produto);
		em.flush();
		return produto;
	}
	public void remove(int id) {
	    Produto prod = findProduto(id);
	    if (prod != null) {
	    em.remove(prod);
	    }
	}			
}
	