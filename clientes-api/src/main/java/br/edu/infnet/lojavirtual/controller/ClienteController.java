package br.edu.infnet.lojavirtual.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.lojavirtual.model.Cliente;
import br.edu.infnet.lojavirtual.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ClienteController {

		@Autowired
		private  ClienteService clienteService;
		@ApiOperation(value = "Retorna uma lista de clientes")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Lista retornada com sucesso"),
				@ApiResponse(code = 400, message = "Erro de chamada da API"),
				@ApiResponse(code = 500, message = "Falha no processamento da chamada")	
		})
		@GetMapping
		public List<Cliente> listaTodos() {
			return clienteService.listaTodos();
		}
		
		@ApiOperation(value = "Exibe um cliente")
		@GetMapping(value = "/clientes/{id}" , produces = "application/json", consumes = "application/json")
		public ResponseEntity<Cliente> exibir(@PathVariable(value="id")Long id) {
			Optional<Cliente> existe = clienteService.obterPorId(id);
			if(!existe.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {				
				return new ResponseEntity<Cliente>(existe.get(), HttpStatus.OK);
			}
		}
		
		@ApiOperation(value = "Salva um novo Cliente")
		@PostMapping(value = "/clientes", produces = "application/json", consumes = "application/json")
		public Cliente criar(@RequestBody Cliente cliente) {
			return clienteService.salvar(cliente);
		}
		
		@ApiOperation(value = "Edita um Cliente")
		@PutMapping(value = "/clientes/{id}" , produces = "application/json", consumes = "application/json")
		public ResponseEntity<Cliente> editar(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
			Optional<Cliente> existe = clienteService.obterPorId(id); 
			if(!existe.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				clienteService.alterar(id, cliente);
				return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
			}
			
		}
		
		@ApiOperation(value = "Remove um cliente")
		@DeleteMapping(value = "/clientes/{id}", produces = "application/json", consumes = "application/json")
		public ResponseEntity<Object> deletar(@PathVariable(value="id")Long id) {
			Optional<Cliente> cliente = clienteService.obterPorId(id);
			if(!cliente.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				clienteService.deletar(id);
				String deletado = "id " + id + " Deletado com sucesso";
				return new ResponseEntity<>(deletado, HttpStatus.OK);
			}
		}
		
		public ClienteService getClienteService() {
			return clienteService;
		}

		public void setClienteService(ClienteService clienteService) {
			this.clienteService = clienteService;
		}
}
