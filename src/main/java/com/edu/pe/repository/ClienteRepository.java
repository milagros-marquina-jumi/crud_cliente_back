package com.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.pe.models.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

	@Query(value = "{call SP_DEL_Cliente(?1)} ", nativeQuery = true)
	public int EliminarPorId(Integer id);
}
 