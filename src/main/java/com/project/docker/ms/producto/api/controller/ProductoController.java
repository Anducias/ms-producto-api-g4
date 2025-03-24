package com.project.docker.ms.producto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.docker.ms.producto.api.model.Producto;
import com.project.docker.ms.producto.api.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public List<Producto> listarProductos() {
		return productoService.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> obtenerProducto(@PathVariable("id") Long id) {
		return productoService.obtenerPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
		Producto nuevoProducto = productoService.agregar(producto);
		return ResponseEntity.ok(nuevoProducto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Producto> actualizarProducto(@PathVariable("id") Long id, @RequestBody Producto producto) {
		return productoService.actualizar(id, producto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable("id") Long id) {
		return productoService.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
	
}