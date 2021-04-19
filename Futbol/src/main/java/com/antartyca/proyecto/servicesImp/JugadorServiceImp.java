package com.antartyca.proyecto.servicesImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.antartyca.proyecto.model.JugadorModel;
import com.antartyca.proyecto.repository.JugadorRepository;
import com.antartyca.proyecto.services.JugadorService;

/*
 * Authors: Eduardo Fachal and Aitor Gonzalez
 * Date: 21/3/2021
 * 
 */

@Service
public class JugadorServiceImp implements JugadorService{

	@Autowired
	JugadorRepository jugadorRepo;

	@Override
	public JugadorModel savePlayer(JugadorModel jugador) {
		JugadorModel result = new JugadorModel();
		try {
			result = jugadorRepo.save(jugador);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public List<JugadorModel> getAllPlayers() {
		List<JugadorModel> result = new ArrayList<>();
		try {
			result = jugadorRepo.findAll();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public JugadorModel getById(Integer id) {
		JugadorModel result = new JugadorModel();
		try {
			result = jugadorRepo.findById(id).get();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public List<JugadorModel> getByFilter(JugadorModel filter) {
		List<JugadorModel> result = new ArrayList<>();
		try {
			Example<JugadorModel> exmple = Example.of(filter);
			result = jugadorRepo.findAll(exmple);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	/* 	Se recoge a través de un JSON la información de un jugador, primero se comprueba
 	si existe el jugador o no.
	En caso de existir buscará el equipo cuya id coincida y modificara los campos de nombre, descripcion,...
	En caso contrario mostrará por la consola un mensaje de jugador no encontrado 
	Además en caso de que se modificara un equipo, se comprobaria previamente si fuera on nulo*/
	
	@Override
	public JugadorModel updatePlayer(JugadorModel jugador) {
		JugadorModel result = new JugadorModel();
		try {
			if(jugadorRepo.existsById(jugador.getCod_jugador())) {
				result = jugadorRepo.findById(jugador.getCod_jugador()).get();
				if(jugador.getNombre()!= null) {
					result.setNombre(jugador.getNombre());
				}
				if(jugador.getPuesto()!= null) {
					result.setPuesto(jugador.getPuesto());
				}
				if(jugador.getTelefono()!= null) {
					result.setTelefono(jugador.getTelefono());
				}
				if(jugador.getEquipo()!=null) {
					result.setEquipo(jugador.getEquipo());
				}
				result = jugadorRepo.save(result);
			}else {
				System.out.println("No existe el jugador buscado");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	@Override
	public void deleteById(Integer id) {
		try {
			if(id != null) {
				jugadorRepo.deleteById(id);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
