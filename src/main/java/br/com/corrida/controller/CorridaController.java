package br.com.corrida.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class CorridaController {

	private final Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	protected CorridaController() {
		this(null);
	}
	
	@Inject
	public CorridaController(Result result) {
		this.result = result;
	}

	@Path("/corrida")
	public void home() {
		result.include("head", "Corridas");
	}
}