package br.com.corrida.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.corrida.interfaces.PassageiroDAO;
import br.com.corrida.model.Passageiro;

public class JPAPassageiroDAO implements PassageiroDAO {
	
	private final EntityManager manager;
	
	@Inject
	public JPAPassageiroDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Deprecated
	public JPAPassageiroDAO() {
		this(null);
	}

	@Override
	public void create(Passageiro passageiro) {
		this.manager.getTransaction().begin();
		
		if(passageiro.getId() == null)
			this.manager.persist(passageiro);
		else
			this.manager.merge(passageiro);
		
		this.manager.getTransaction().commit();
	}

	@Override
	public List<Passageiro> readAll() {
		this.manager.getTransaction().begin();
		
		List<Passageiro> passageiros = this.manager
				.createQuery("select p from Passageiro p", Passageiro.class)
				.getResultList();
		
		this.manager.getTransaction().commit();
		
		return passageiros;
	}

}
