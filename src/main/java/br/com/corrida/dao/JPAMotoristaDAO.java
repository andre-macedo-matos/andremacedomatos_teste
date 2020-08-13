package br.com.corrida.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.corrida.interfaces.MotoristaDAO;
import br.com.corrida.model.Motorista;

public class JPAMotoristaDAO implements MotoristaDAO {
	
	private final EntityManager manager;
	
	@Inject
	public JPAMotoristaDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Deprecated
	public JPAMotoristaDAO() {
		this(null);
	}

	@Override
	public void create(Motorista motorista) {
		this.manager.getTransaction().begin();
		
		if(motorista.getId() == null)
			this.manager.persist(motorista);
		else
			this.manager.merge(motorista);
		
		this.manager.getTransaction().commit();
	}

	@Override
	public List<Motorista> read(Long id) {
		this.manager.getTransaction().begin();
		
		List<Motorista> motoristas = this.manager
				.createQuery("select m from Motorista m", Motorista.class)
				.getResultList();
		
		this.manager.getTransaction().commit();
		
		return motoristas;
	}

	@Override
	public void update(Long id) {
		// TODO Auto-generated method stub
		
	}

}
