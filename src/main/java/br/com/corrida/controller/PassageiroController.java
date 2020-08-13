package br.com.corrida.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.corrida.interfaces.MotoristaDB;
import br.com.corrida.interfaces.PassageiroDB;
import br.com.corrida.model.Motorista;
import br.com.corrida.model.Passageiro;

@Controller
public class PassageiroController {

	private final Result result;
	private final PassageiroDB db;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected PassageiroController() {
		this(null, null);
	}
	
	@Inject
	public PassageiroController(Result result, PassageiroDB db) {
		this.result = result;
		this.db = db;
	}

	@Path("/passageiros")
	public List<Passageiro> read() {
		result.include("head", "Passageiros");
		return db.readAll();
	}
	
	public void create(Passageiro passageiro) {
		db.create(passageiro);
		result.redirectTo(this).read( );
	}
}