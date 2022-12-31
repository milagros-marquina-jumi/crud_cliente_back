package com.edu.pe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.pe.models.*;
import com.edu.pe.service.*;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin
public class ClienteController {
	@Autowired
	private IClienteService service;

	@GetMapping("/listarTodos")
	public ResponseEntity<List<Cliente>> getListClientes(){
		List<Cliente> lista = service.Listado();
		return new ResponseEntity<List<Cliente>>(lista ,HttpStatus.OK);
	}
	
	
	@PostMapping("/guardar")
	public ResponseEntity GuardarCliente(@RequestBody Cliente e) {
		try {
			System.out.println(e.toString());
			boolean estado = service.Guardar(e);
			return ResponseEntity.ok(estado);
		}catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping(path = "/eliminar/{id}")
	public ResponseEntity EliminarCliente(@PathVariable("id") Integer id){
		Cliente e = service.BuscarPorId(id);
		
		if(e !=null) {
			boolean estado = service.Eliminar(id);
			
			return ResponseEntity.ok(estado);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
