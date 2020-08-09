package br.com.corrida.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class HomeController {

	private final Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	protected HomeController() {
		this(null);
	}
	
	@Inject
	public HomeController(Result result) {
		this.result = result;
	}

	@Path({"/", "/home"})
	public void home() {
		result.include("head", "Corridas Compartilhadas!");
	}
}