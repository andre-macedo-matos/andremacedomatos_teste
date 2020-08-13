package br.com.corrida.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.corrida.dao.interfaces.CorridaDAO;
import br.com.corrida.model.Corrida;
import br.com.corrida.model.Motorista;
import br.com.corrida.model.Passageiro;

public class JPACorridaDAO implements CorridaDAO {
	
	private final EntityManager manager;
	
	@Inject
	public JPACorridaDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Deprecated
	public JPACorridaDAO() {
		this(null);
	}

	@Override
	public void create(Corrida corrida) {
		this.manager.getTransaction().begin();
		
		if(corrida.getId() == null)
			this.manager.persist(corrida);
		else
			this.manager.merge(corrida);
		
		this.manager.getTransaction().commit();
	}

	@Override
	public List<Corrida> readAll() {
		this.manager.getTransaction().begin();
		
		List<Corrida> corridas = this.manager
				.createQuery("select c from Corrida c", Corrida.class)
				.getResultList();
		
		this.manager.getTransaction().commit();
		
		return corridas;
	}

}
