package br.com.corrida.database;

import java.util.List;

import javax.inject.Inject;

import br.com.corrida.interfaces.PassageiroDAO;
import br.com.corrida.interfaces.PassageiroDB;
import br.com.corrida.model.Passageiro;

public class PassageiroDatabase implements PassageiroDB {
	
	private final PassageiroDAO dao;
	
	@Inject
	public PassageiroDatabase(PassageiroDAO dao) {
		this.dao = dao;
	}
	
	@Deprecated
	public PassageiroDatabase() {
		this(null);
	}

	@Override
	public void create(Passageiro passageiro) {
		this.dao.create(passageiro);
	}

	@Override
	public List<Passageiro> readAll() {
		return this.dao.readAll();
	}


}
