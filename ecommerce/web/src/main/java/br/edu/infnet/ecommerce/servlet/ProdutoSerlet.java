package br.edu.infnet.ecommerce.servlet;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.ecommerce.ejb.ProdutoEjb;
import br.edu.infnet.ecommerce.modelo.Produto;


@WebServlet(name = "prod" , urlPatterns = "/prod")
public class ProdutoSerlet extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoEjb produtoEjb;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try {
			List<Produto> produtos = produtoEjb.list();	
			req.setAttribute("listaProdutos", produtos);
			req.getRequestDispatcher("prod.jsp").forward(req, resp);
			System.out.println(produtos);
		} catch (Exception e) {
			req.getRequestDispatcher("prod.jsp").forward(req, resp);
		}		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("idProd") != null) {
            int idProd = Integer.valueOf(req.getParameter("idProd"));
            produtoEjb.remove(idProd);
            req.setAttribute("mensagem", "Exclusão realizada!");
        } else {

		resp.setContentType("text/html");
		String nome = req.getParameter("nome");
		Double preco = Double.valueOf(req.getParameter("preco"));
			
		Produto produto = produtoEjb.add(new Produto(nome, preco));
	    produto.setNome(nome);
	    produto.setPreco(preco);
	    
		req.setAttribute("produto", produto);
		System.out.println(produto);
        }
		this.doGet(req, resp);		
	}	
}