package br.com.corrida.database.interfaces;

import java.util.List;

import br.com.corrida.model.Motorista;

public interface MotoristaDB {

	void create(Motorista motorista);
	
	List<Motorista> readAll();
	
	Motorista readBy(Long id);
	
	void update(Long id, Character status);
}
