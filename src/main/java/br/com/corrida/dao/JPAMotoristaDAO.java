package br.com.corrida.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.corrida.dao.interfaces.MotoristaDAO;
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
	public List<Motorista> readAll() {
		this.manager.getTransaction().begin();
		
		List<Motorista> motoristas = this.manager
				.createQuery("select m from Motorista m", Motorista.class)
				.getResultList();
		
		this.manager.getTransaction().commit();
		
		return motoristas;
	}
	
	@Override
	public Motorista readBy(Long id) {
		this.manager.getTransaction().begin();
		
		Motorista motorista = this.manager
				.createQuery("select m from Motorista m where m.id = :id", Motorista.class)
				.setParameter("id", id)
				.getSingleResult( );
		
		this.manager.getTransaction().commit();
		
		return motorista;
	}

	@Override
	public void update(Long id, Character status) {
		this.manager.getTransaction().begin();
		
		this.manager.createNativeQuery("update Motorista m set m.status = :novoStatus where m.id = :id")
			.setParameter("novoStatus", status)
			.setParameter("id", id.intValue())
			.executeUpdate();
		
		this.manager.getTransaction().commit();
	}


}
