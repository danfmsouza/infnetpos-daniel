package br.edu.infnet.ecommerce.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import br.edu.infnet.ecommerce.modelo.Carrinho;
import br.edu.infnet.ecommerce.ejb.CarrinhoEjb;

@MessageDriven(activationConfig = {
@ActivationConfigProperty(propertyName = "destination",
						  propertyValue = "java:/myjms/myqueue"
)})
public class ConsumerJms implements MessageListener {
	@Inject
	CarrinhoEjb cart;

	@Override
	public void onMessage(Message message) {
		if(message instanceof ObjectMessage) {
			try {				
				ObjectMessage msg = (ObjectMessage) message;							
				Carrinho carrinho = (Carrinho)msg.getObject();				
				carrinho.setVendido(true);
				System.out.println(carrinho);
				cart.pagar(carrinho);
				System.out.println("======= MDB/JMS =======");
				System.out.println("Carrinho numero " + carrinho.getId() + " pago!");
				System.out.println("======= MDB/JMS =======");
				
			} catch (Exception e) {
				System.err.println("Ocorreu um erro ao processar o pagamento!");
			}
		}
	}
}
