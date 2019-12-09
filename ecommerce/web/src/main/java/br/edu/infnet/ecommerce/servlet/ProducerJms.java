package br.edu.infnet.ecommerce.servlet;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;

import br.edu.infnet.ecommerce.ejb.CarrinhoEjb;
import br.edu.infnet.ecommerce.modelo.Carrinho;

public class ProducerJms {

	@Resource(lookup = "java:/myjms/Mycon")
	ConnectionFactory connectionFactory;
	
	@Resource(lookup = "java:/myjms/myqueue")
	Destination destination;	
	
	@Inject
	CarrinhoEjb cart;
	
	public void enviarPedido(Carrinho carrinho) {		
		try {						
			QueueConnection connection = (QueueConnection) connectionFactory.createConnection();			
			QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);			
			MessageProducer producer = session.createProducer(destination);			
			ObjectMessage message = session.createObjectMessage(carrinho);		
			
			producer.send(message);			
			producer.close();
			session.close();
			connection.close();
			System.out.println("Carrinho numero " + carrinho.getId() + " enviado para pagamento!");
		} catch (Exception e) {
			System.err.println("HOUVE UMA FALHA " + e.getMessage());	
			System.out.println("Carrinho numero " + carrinho.getId() + " NÃO ENVIADO!!!");
		}

	}

	public void pedido(Carrinho carrinho) {
		try {			
			cart.guardar(carrinho);
			this.enviarPedido(carrinho);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());	
			throw new RuntimeException();
		}

	}
}
