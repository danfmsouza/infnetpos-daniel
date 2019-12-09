package br.edu.infnet.ecommerce.mb;

import java.net.ConnectException;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.infnet.ecommerce.modelo.Cliente;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ClienteMb {
	@PersistenceContext(unitName = "br.edu.infnet.ecommerce")
	private EntityManager em;
	private static final String API = "http://localhost:8181/api";
	private Client client =  ClientBuilder.newClient();	
	WebTarget webTarget = client.target(API);
	
	public Cliente findCliente(Integer id) {
		webTarget = this.client.target(API).path("clientes").path(String.valueOf(id));
		Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8");
		Response response = invocationBuilder.get();
		return response.readEntity(Cliente.class);
	}
	public ClienteMb(){
		this.client = client;  
	}
	
	public List<Cliente> listar() throws ConnectException {
		try {
			return client.target(API).path("clientes").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Cliente>>(){});
		} catch (ProcessingException e) {
			throw new ProcessingException(e);
		}
	}
	
	public Cliente salvar(Cliente cliente) throws ConnectException {
		try {
			Response response = client.target(API).path("clientes").request(MediaType.APPLICATION_JSON).post(Entity.entity(cliente, MediaType.APPLICATION_JSON));
			if (Integer.valueOf(response.getStatus()) == 422) {
				throw new RuntimeException();
			}			
			return response.readEntity(Cliente.class);			
		} catch (ProcessingException e) {
			throw new ProcessingException(e);
		}
	}
}