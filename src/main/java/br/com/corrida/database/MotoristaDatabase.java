package br.com.corrida.database;

import java.util.List;

import javax.inject.Inject;

import br.com.corrida.dao.interfaces.MotoristaDAO;
import br.com.corrida.database.interfaces.MotoristaDB;
import br.com.corrida.model.Motorista;

public class MotoristaDatabase implements MotoristaDB {
	
	private final MotoristaDAO dao;
	
	@Inject
	public MotoristaDatabase(MotoristaDAO dao) {
		this.dao = dao;
	}
	
	@Deprecated
	public MotoristaDatabase() {
		this(null);
	}

	@Override
	public void create(Motorista motorista) {
		this.dao.create(motorista);
	}

	@Override
	public List<Motorista> readAll() {
		return this.dao.readAll();
	}

	@Override
	public void update(Long id, Character status) {
		this.dao.update(id, status);
	}

}
