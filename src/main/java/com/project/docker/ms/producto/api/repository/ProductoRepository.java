package com.project.docker.ms.producto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.docker.ms.producto.api.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
}