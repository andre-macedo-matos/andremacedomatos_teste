package br.com.corrida.database.interfaces;

import java.util.List;

import br.com.corrida.model.Passageiro;

public interface PassageiroDB {
	void create(Passageiro passageiro);
	
	List<Passageiro> readAll();
}
