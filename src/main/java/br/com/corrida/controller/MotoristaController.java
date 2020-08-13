package br.com.corrida.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.corrida.interfaces.CorridaDB;
import br.com.corrida.model.Motorista;

@Controller
public class MotoristaController {
	
	private final Result result;
	private final CorridaDB db;
	/**
	 * @deprecated CDI eyes only
	 */
	protected MotoristaController() {
		this(null, null);
	}
	
	@Inject
	public MotoristaController(Result result, CorridaDB db) {
		this.result = result;
		this.db = db;
	}

	@Path("/motoristas")
	public List<Motorista> read() {
		result.include("head", "Motoristas!");
		return db.readAll();
	}
	
	public void create(Motorista motorista) {
		System.out.println(motorista.toString());
		db.create(motorista);
		result.redirectTo(this).read( );
	}
}