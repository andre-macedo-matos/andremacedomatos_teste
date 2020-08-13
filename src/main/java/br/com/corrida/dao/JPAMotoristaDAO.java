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
		if(motorista.getId() == null)
			this.manager.persist(motorista);
		else
			this.manager.merge(motorista);
	}

	@Override
	public List<Motorista> read(Long id) {
		return this.manager
				.createQuery("select m from motorista m", Motorista.class)
				.getResultList();
	}

	@Override
	public void update(Long id) {
		// TODO Auto-generated method stub
		
	}

}
