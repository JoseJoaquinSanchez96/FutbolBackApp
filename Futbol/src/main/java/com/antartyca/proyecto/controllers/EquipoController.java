package com.antartyca.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antartyca.proyecto.model.EquipoModel;
import com.antartyca.proyecto.services.EquipoService;

/*
 * Authors: Eduardo Fachal and Aitor Gonzalez
 * Date: 21/3/2021
 * 
 */

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping( value = "/equipo")
public class EquipoController {
	
	@GetMapping("/mensaje")
	  public String mensaje() {
	    return "hola desde spring rest";
	  }
	
	@Autowired
	EquipoService equipoServ;
	
	@RequestMapping(method =  RequestMethod.POST , value = "/equiposave")
	public EquipoModel saveTeam(@RequestBody EquipoModel equipo) {
		return equipoServ.saveTeam(equipo);
		
	}
	
	@RequestMapping(value = "/equipos")
	public List<EquipoModel> getAllTeams(){
		return equipoServ.getAllTeams();
	}
		
	
	@GetMapping(value = "/equipo/{id}")
	public EquipoModel getById(@PathVariable("id") Integer id){
		return equipoServ.getById(id);
	}
	
	@PostMapping(value = "/equipofilter")
	public List<EquipoModel> getByFilter(@RequestBody EquipoModel equipo){
		return equipoServ.getByFilter(equipo);
	}
	
	@GetMapping(value = "/equipoborrar/{id}")
	public void deleteById(@PathVariable("id") Integer id){
		equipoServ.deleteById(id);
	}

	@PostMapping(value = "/equipoupdate")
	public EquipoModel updateTeam(@RequestBody EquipoModel equipo){
		return equipoServ.updateTeam(equipo);
	}
}
