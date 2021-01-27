package com.sanalberto.clientes;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestSystem {
	
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("clientes");
	public static void main(String[] args) {

		getArtist(60);
		
		
		
		
		ENTITY_MANAGER_FACTORY.close();
	}
	
	public static void  getArtist(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "Select a From ArtistManual a where a.artist = :artID";
		
		TypedQuery<Artist> tq = em.createQuery(query, Artist.class);
		tq.setParameter("artID", id);
		Artist art = null;
		try {
			art = tq.getSingleResult();
			System.out.println("--> Artist: " + art.getName());
		} catch (Exception e) {
			System.out.println("Error recuperando el artista");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

}
