package br.com.corrida.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class PassageiroController {

	private final Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	protected PassageiroController() {
		this(null);
	}
	
	@Inject
	public PassageiroController(Result result) {
		this.result = result;
	}

	@Path("/passageiros")
	public void home() {
		result.include("head", "Passageiros");
	}
}