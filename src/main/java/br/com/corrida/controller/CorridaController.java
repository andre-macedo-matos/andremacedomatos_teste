package br.com.corrida.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.corrida.database.interfaces.CorridaDB;
import br.com.corrida.database.interfaces.MotoristaDB;
import br.com.corrida.database.interfaces.PassageiroDB;
import br.com.corrida.model.Corrida;
import br.com.corrida.model.Motorista;
import br.com.corrida.model.Passageiro;

@Controller
public class CorridaController{

	private final Result result;
	private final CorridaDB db;
	private final MotoristaDB motoristaDB;
	private final PassageiroDB passageiroDB;

	/**
	 * @deprecated CDI eyes only
	 */
	protected CorridaController() {
		this(null, null, null, null);
	}
	
	@Inject
	public CorridaController(Result result, CorridaDB db, MotoristaDB motoristaDB, PassageiroDB passageiroDB) {
		this.result = result;
		this.db = db;
		this.motoristaDB = motoristaDB;
		this.passageiroDB = passageiroDB;
	}

	@Path("/corridas")
	public List<Corrida> read() {
		List<Motorista> motoristas = motoristaDB.readAll( );
		List<Passageiro> passsageiros = passageiroDB.readAll( );
		
		result.include("motoristas", motoristas);
		result.include("passageiros", passsageiros);
		result.include("head", "Corridas!");
		
		List<Corrida> corridas = db.readAll();
		return corridas;
	}
	
	@SuppressWarnings("deprecation")
	public void create(Long motoristaId, Long passageiroId, double valorCorrida) {
		Motorista motorista = motoristaDB.readBy(motoristaId);
		Passageiro passageiro = passageiroDB.readBy(passageiroId);
		
		Corrida corrida = new Corrida();
		corrida.setMotorista(motorista);
		corrida.setPassageiro(passageiro);
		corrida.setValor(valorCorrida);
		
		db.create(corrida);
		result.redirectTo(this).read( );
	}
}