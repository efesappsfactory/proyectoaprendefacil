package ec.edu.epn.modelo.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ec.edu.epn.modelo.Local;

public class GestorLocales {
 
	public void crearLocal(Local local) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("LocalesNetJPA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(local);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Local> buscarLocales (String nombreBusqueda){
		List <Local> locales= new ArrayList<Local>();
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("LocalesNetJPA");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select l from Local as l where l.nombre like ? ",Local.class);
		q.setParameter(1, nombreBusqueda+"%");
		locales = q.getResultList();
		return locales;
	}
	 
}
