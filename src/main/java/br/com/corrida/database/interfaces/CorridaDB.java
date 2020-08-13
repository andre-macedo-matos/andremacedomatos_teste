package br.com.corrida.database.interfaces;

import java.util.List;

import br.com.corrida.model.Corrida;
import br.com.corrida.model.Motorista;
import br.com.corrida.model.Passageiro;

public interface CorridaDB {
	void create(Corrida Corrida);
	
	List<Corrida> readAll();
	
}