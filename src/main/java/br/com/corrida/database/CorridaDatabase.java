package br.com.corrida.database;

import java.util.List;

import javax.inject.Inject;

import br.com.corrida.interfaces.CorridaDB;
import br.com.corrida.interfaces.DAO;
import br.com.corrida.model.Motorista;

public class CorridaDatabase implements CorridaDB {
	
	private final DAO dao;
	
	@Inject
	public CorridaDatabase(DAO dao) {
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
	public List<Motorista> readAll() {
		// TODO Auto-generated method stub
		return this.dao.readAll();
	}

	@Override
	public void update(Long id) {
		this.dao.update(id);
	}

}
