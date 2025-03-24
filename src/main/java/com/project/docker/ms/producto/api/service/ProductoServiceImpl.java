package com.project.docker.ms.producto.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.docker.ms.producto.api.model.Producto;
import com.project.docker.ms.producto.api.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	/*
	public ProductoServiceImpl(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	*/
	
	@Override
	public List<Producto> listar() {
		return productoRepository.findAll();
	}
	
	@Override
	public Optional<Producto> obtenerPorId(Long id) {
		return productoRepository.findById(id);
	}
	
	@Override
	public Producto agregar(Producto producto) {
		return productoRepository.save(producto);
	}
	
	@Override
	public Optional<Producto> actualizar(Long id, Producto nuevoProducto) {
		return productoRepository.findById(id).map(producto -> {
			producto.setNombre(nuevoProducto.getNombre());
			producto.setDescripcion(nuevoProducto.getDescripcion());
			producto.setPrecio(nuevoProducto.getPrecio());
			return productoRepository.save(producto);
		});
	}
	
	@Override
	public boolean eliminar(Long id) {
		if (productoRepository.existsById(id)) {
			productoRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}