package br.edu.infnet.ecommerce.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.ecommerce.ejb.CarrinhoEjb;
import br.edu.infnet.ecommerce.ejb.ProdutoEjb;
import br.edu.infnet.ecommerce.mb.ClienteMb;
import br.edu.infnet.ecommerce.modelo.Carrinho;
import br.edu.infnet.ecommerce.modelo.Produto;
//import br.edu.infnet.ecommerce.modelo.Cliente;

@WebServlet(name = "cart", urlPatterns = "/cart")
public class CarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 5729397261145306745L;
	
	@Inject
	private CarrinhoEjb cart;
	
	@Inject
	private ProdutoEjb prod;
	
	@Inject
	private ProducerJms pagamento;
	
	@Inject
	private ClienteMb user;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		req.setAttribute("listaClientes", user.listar());
		try {
			List<Produto> inCart = cart.listarProd();
			resp.setContentType("text/html");	
			req.setAttribute("inCart", inCart);
			req.getRequestDispatcher("cart.jsp").forward(req, resp);			
		} catch (Exception e) {
			req.getRequestDispatcher("cart.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    resp.setContentType("text/html");
    	req.setAttribute("listaClientes", user.listar());
	    List<Produto> produtos = new ArrayList<Produto>();
	    Integer id = Integer.valueOf(req.getParameter("idProd"));
	    
	    if (id == 0) {
	    	//Cliente cliente = user.findCliente(Integer.valueOf(req.getParameter("cliente")));
	    	List<Produto> inCart = cart.listarProd();
			req.setAttribute("inCart", inCart);
	    	Carrinho carrinho = new Carrinho();
	    	carrinho.setVendido(false);
	    	// carrinho.setCliente(cliente);
	    	carrinho.setProdutos(inCart);
	    	System.out.println(carrinho);
	    	// System.out.println("CLIENTE ==== " + cliente);
		    pagamento.pedido(carrinho);
		    req.getRequestDispatcher("index.jsp").forward(req, resp);

		} else {
		    produtos.add(prod.findProduto(id));
		    Produto produto = prod.findProduto(id);
		    System.out.println("ADD " + produto);
		    cart.addProd(id, produto);
		    this.doGet(req, resp);
		}
	    List<Produto>inCart = cart.listarProd();
		req.setAttribute("inCart", inCart);
	}

}
