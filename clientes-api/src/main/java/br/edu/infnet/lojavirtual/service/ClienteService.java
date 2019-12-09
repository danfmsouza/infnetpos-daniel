package br.edu.infnet.lojavirtual.service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.infnet.lojavirtual.model.Cliente;
import br.edu.infnet.lojavirtual.model.persistence.ClienteRepository;

@Service
public class ClienteService {
	private ClienteRepository repository;
	
	ClienteService(ClienteRepository clienteRepository) {
		this.repository = clienteRepository;
	}
	
	public List<Cliente> listaTodos() {
		return new ArrayList<Cliente>(repository.findAll());
	}

	public Cliente salvar(Cliente cliente) {
		return repository.save(cliente);
	}

	public Cliente alterar(Long id, Cliente cliente) {
		return repository.save(cliente);
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}

	public Optional<Cliente> obterPorId(Long id) {
		return repository.findById(id); 
	}
}
