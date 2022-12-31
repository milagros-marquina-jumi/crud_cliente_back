package com.edu.pe.service;

import java.util.List;

import com.edu.pe.models.Cliente;

public interface IClienteService {
	
	public boolean Guardar(Cliente obj);
	
	public boolean Eliminar(Integer id);
	
	public List<Cliente> Listado();
	
	public Cliente BuscarPorId(Integer id);
}
