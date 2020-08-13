package br.com.corrida.database;

import java.util.List;

import javax.inject.Inject;

import br.com.corrida.interfaces.CorridaDB;
import br.com.corrida.interfaces.MotoristaDAO;
import br.com.corrida.model.Motorista;

public class CorridaDatabase implements CorridaDB {
	
	private final MotoristaDAO dao;
	
	@Inject
	public CorridaDatabase(MotoristaDAO dao) {
		this.dao = dao;
	}
	
	@Deprecated
	public CorridaDatabase() {
		this(null);
	}

	@Override
	public void create(Motorista motorista) {
		this.dao.create(motorista);
	}

	@Override
	public List<Motorista> read(Long id) {
		// TODO Auto-generated method stub
		return this.dao.read(id);
	}

	@Override
	public void update(Long id) {
		this.dao.update(id);
	}

}
