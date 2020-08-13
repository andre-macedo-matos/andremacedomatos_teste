package br.com.corrida.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.corrida.interfaces.MotoristaDB;
import br.com.corrida.model.Motorista;

@Controller
public class MotoristaController {
	
	private final Result result;
	private final MotoristaDB db;
	/**
	 * @deprecated CDI eyes only
	 */
	protected MotoristaController() {
		this(null, null);
	}
	
	@Inject
	public MotoristaController(Result result, MotoristaDB db) {
		this.result = result;
		this.db = db;
	}

	@Path("/motoristas")
	public List<Motorista> read() {
		result.include("head", "Motoristas!");
		return db.readAll();
	}
	
	public void create(Motorista motorista) {
		db.create(motorista);
		result.redirectTo(this).read( );
	}
	
	public void update(Long id, Character status, Result result) {
		db.update(id, status);
		result.redirectTo(this).read();
	}
}