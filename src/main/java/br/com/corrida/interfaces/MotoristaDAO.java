package br.com.corrida.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import br.com.corrida.model.Motorista;

@Transactional
public interface MotoristaDAO {
	
	void create(Motorista motorista);
	
	List<Motorista> readAll();
	
	void update(Long id, Character status);
}
