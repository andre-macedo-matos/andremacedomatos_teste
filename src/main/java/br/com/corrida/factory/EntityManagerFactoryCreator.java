package br.com.corrida.factory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.vraptor.environment.Environment;

@Alternative
public class EntityManagerFactoryCreator  {
	
	@Inject 
	private Environment environment;

	@ApplicationScoped
	@Produces
	public EntityManagerFactory getEntityManagerFactory() {
		String persistenceUnit = environment.get("br.com.caelum.vraptor.jpa.persistenceunit", "default");
		return Persistence.createEntityManagerFactory(persistenceUnit);
	}

	public void destroy(@Disposes EntityManagerFactory factory) {
		if (factory.isOpen()) {
			factory.close();
		}
	}
}
