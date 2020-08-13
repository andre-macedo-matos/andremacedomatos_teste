package br.com.corrida.interfaces;

import java.util.List;

import br.com.corrida.model.Motorista;

public interface CorridaDB {

	void create(Motorista motorista);
	
	List<Motorista> readAll();
	
	void update(Long id, Character status);
}
