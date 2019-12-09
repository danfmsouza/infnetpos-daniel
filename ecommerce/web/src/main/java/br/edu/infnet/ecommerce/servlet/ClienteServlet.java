package br.edu.infnet.ecommerce.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.ecommerce.mb.ClienteMb;
import br.edu.infnet.ecommerce.modelo.Cliente;

@WebServlet(name = "user", urlPatterns = "/user")
public class ClienteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteMb user;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listaClientes", user.listar());
		req.getRequestDispatcher("user.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cliente cliente = new Cliente(req.getParameter("usuario"), req.getParameter("email"));		
				user.salvar(cliente);	
				req.setAttribute("cliente", cliente);
				this.doGet(req, resp);
	}	
}