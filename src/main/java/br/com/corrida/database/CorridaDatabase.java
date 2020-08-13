package br.com.corrida.database;

import java.util.List;

import javax.inject.Inject;

import br.com.corrida.dao.interfaces.CorridaDAO;
import br.com.corrida.database.interfaces.CorridaDB;
import br.com.corrida.model.Corrida;

public class CorridaDatabase implements CorridaDB {
	
	private final CorridaDAO dao;
	
	@Inject
	public CorridaDatabase(CorridaDAO dao) {
		this.dao = dao;
	}
	
	@Deprecated
	public CorridaDatabase() {
		this(null);
	}

	@Override
	public void create(Corrida Corrida) {
		this.dao.create(Corrida);
	}

	@Override
	public List<Corrida> readAll() {
		return this.dao.readAll();
	}
}
