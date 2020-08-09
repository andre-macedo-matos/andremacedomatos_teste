package br.com.corrida.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class MotoristaController {

	private final Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	protected MotoristaController() {
		this(null);
	}
	
	@Inject
	public MotoristaController(Result result) {
		this.result = result;
	}

	@Path("/motoristas")
	public void home() {
		result.include("head", "Motoristas!");
	}
}