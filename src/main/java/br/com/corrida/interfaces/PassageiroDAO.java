package br.com.corrida.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import br.com.corrida.model.Passageiro;

@Transactional
public interface PassageiroDAO {

	void create(Passageiro passageiro);
	
	List<Passageiro> readAll();
}
