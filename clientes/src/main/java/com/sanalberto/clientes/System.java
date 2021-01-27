package com.sanalberto.clientes;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class System {
	
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("clientes");
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
