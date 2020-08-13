package br.com.corrida.dao.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import br.com.corrida.model.Corrida;
import br.com.corrida.model.Motorista;
import br.com.corrida.model.Passageiro;

@Transactional
public interface CorridaDAO {

	void create(Corrida Corrida);
	
	List<Corrida> readAll();
}
