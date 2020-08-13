package br.com.corrida.dao.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import br.com.corrida.model.Motorista;

@Transactional
public interface MotoristaDAO {
	
	void create(Motorista motorista);
	
	List<Motorista> readAll();
	
	Motorista readBy(Long id);
	
	void update(Long id, Character status);
}
