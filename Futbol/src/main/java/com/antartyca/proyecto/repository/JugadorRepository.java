package com.antartyca.proyecto.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.antartyca.proyecto.model.JugadorModel;

/*
 * Authors: Eduardo Fachal and Aitor Gonzalez
 * Date: 21/3/2021
 * 
 */

@Repository
public interface JugadorRepository extends JpaRepository<JugadorModel,Integer>{
	
	/*
	@Query("select u from JugadorModel u where u.nombre like :nombre order by u.nombre")
	List<JugadorModel> buscaPorNombre(@Param("nombre") String nombre);
	*/
	/*
	@Query("SELECT j FROM JugadorModel j")
	List<JugadorModel> findAllPlayers();
	*/
	
}

