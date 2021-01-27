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

		//getArtist(60);
		//getCustomer(3);
		//getInvoice(1);
		//getInvoiceByCustomerId(10);
		getCustomerByLastName("Tremblay");
		
		
		
		ENTITY_MANAGER_FACTORY.close();
	}
	
	public static void  getArtist(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "Select a From Artist a where a.artistId = :artID";
		
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
	
	public static void getCustomer(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "Select a From Customer a where a.customerId = :cusID";
		
		TypedQuery<Customer> tq = em.createQuery(query, Customer.class);
		tq.setParameter("cusID", id);
		Customer cus = null;
		try {
			cus = tq.getSingleResult();
			System.out.println("Cliente: " + cus.getFirstName() + " " + cus.getLastName());
		} catch (Exception e) {
			System.out.println("Error al recuperar el cliente");
			e.printStackTrace();
		}
	}
	
	public static void getCustomerByLastName(String lastName) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "Select a From Customer a where a.lastName Like :lastName";
		
		TypedQuery<Customer> tq = em.createQuery(query, Customer.class);
		tq.setParameter("lastName", lastName);
		Customer cus = null;
		try {
			cus = tq.getSingleResult();
			System.out.println("Cliente: " + cus.getFirstName() + " " + cus.getLastName());
		} catch (Exception e) {
			System.out.println("Error al recuperar el cliente");
			e.printStackTrace();
		}
	}
	
	public static void getInvoice(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "Select a From Invoice a where a.invoiceId = :invID";
		
		TypedQuery<Invoice> tq = em.createQuery(query, Invoice.class);
		tq.setParameter("invID", id);
		Invoice inv = null;
		
		try {
			inv = tq.getSingleResult();
			System.out.println("Factura: " + inv.getInvoiceId());
			
		} catch (Exception e) {
			System.out.println("Error al recuperar el cliente");
			e.printStackTrace();
		}
	}
	
	
	
	public static void getInvoiceByCustomerId(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "Select a From Invoice a where a.customer = :cusID";
		
		TypedQuery<Invoice> tq = em.createQuery(query, Invoice.class);
		tq.setParameter("cusID", id);
		Invoice inv = null;
		
		try {
			inv = tq.getSingleResult();
			System.out.println("Factura: " + inv.getInvoiceId() + " " + inv.getCustomer());
			
		} catch (Exception e) {
			System.out.println("Error al recuperar el cliente");
			e.printStackTrace();
		}
	}

}
