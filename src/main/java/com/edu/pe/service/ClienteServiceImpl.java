package com.edu.pe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.pe.models.Cliente;
import com.edu.pe.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private ClienteRepository repo;
	
	@Transactional
	@Override
	public boolean Guardar(Cliente obj) {
		 try {
			 repo.save(obj);
			 return true;
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return false;
	}

	@Override
	public boolean Eliminar(Integer id) {
		try {
			//repo.deleteById(id);
			return repo.EliminarPorId(id)> 0;
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return false;
	}

	@Override
	public List<Cliente> Listado() {
		return repo.findAll();
	}

	@Override
	public Cliente BuscarPorId(Integer id) {
		return  repo.findById(id).orElse(null);
	}

}
