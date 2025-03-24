package com.project.docker.ms.producto.api.service;

import java.util.List;
import java.util.Optional;

import com.project.docker.ms.producto.api.model.Producto;

public interface ProductoService {
	
	/**
	 * Listar todos los productos
	 * @return
	 */
	List<Producto> listar();
	
	/**
	 * Obtener un producto por id
	 * @param id
	 * @return
	 */
	Optional<Producto> obtenerPorId(Long id);
	
	/**
	 * Agregar un producto
	 * @param producto
	 * @return
	 */
	Producto agregar(Producto producto);
	
	/**
	 * Actualizar un producto
	 * @param id
	 * @param nuevoProducto
	 * @return
	 */
	Optional<Producto> actualizar(Long id, Producto nuevoProducto);
	
	/**
	 * Eliminar un producto
	 * @param id
	 * @return
	 */
	boolean eliminar(Long id);
	
}