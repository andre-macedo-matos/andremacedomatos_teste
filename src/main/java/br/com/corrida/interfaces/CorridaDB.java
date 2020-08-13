package br.com.corrida.interfaces;

import java.util.List;

import br.com.corrida.model.Motorista;

public interface CorridaDB {

	void create(Motorista motorista);
	
	List<Motorista> read(Long id);
	
	void update(Long id);
}
