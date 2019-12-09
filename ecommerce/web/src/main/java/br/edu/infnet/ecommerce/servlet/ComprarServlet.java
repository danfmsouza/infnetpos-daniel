package br.edu.infnet.ecommerce.servlet;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.ecommerce.ejb.CarrinhoEjb;
import br.edu.infnet.ecommerce.ejb.ProdutoEjb;
import br.edu.infnet.ecommerce.modelo.Produto;

// ComprarServlet responsável na administração dos itens que entram no carrinho antes do pagamento

@WebServlet(name = "buy", urlPatterns = "/buy")
public class ComprarServlet extends HttpServlet {
	private static final long serialVersionUID = 5729397261145306745L;
	
	@Inject
	private CarrinhoEjb cart;
	
	@Inject
	private ProdutoEjb prod;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			List<Produto> produtos = prod.list();
			resp.setContentType("text/html");	
			req.setAttribute("listaProdutos", produtos);
			req.getRequestDispatcher("buy.jsp").forward(req, resp);			
		} catch (Exception e) {
			req.getRequestDispatcher("buy.jsp").forward(req, resp);
		}

	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    resp.setContentType("text/html");
	    Integer id = Integer.valueOf(req.getParameter("idProd"));

	    cart.addProd(id, prod.findProduto(id));
 		
	    List<Produto> inCart = cart.listarProd();
		req.setAttribute("inCart", inCart);
//	    }
		this.doGet(req, resp);
	}

}
