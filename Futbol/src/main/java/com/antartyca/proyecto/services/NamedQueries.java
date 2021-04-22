package com.antartyca.proyecto.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.antartyca.proyecto.model.JugadorModel;

public class NamedQueries {

	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_JPQL");
		EntityManager entitymanager = emfactory.createEntityManager();

		Query query = entitymanager.createNamedQuery("find employee by id");
		query.setParameter("id", 1204);

		List<JugadorModel> list = query.getResultList();

		for (JugadorModel j : list) {
			System.out.print("Jugador ID :" + j.getCod_jugador());
			System.out.println("\t Nombre jugador :" + j.getNombre());
		}

	}

}
