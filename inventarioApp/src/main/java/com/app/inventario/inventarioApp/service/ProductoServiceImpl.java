package com.app.inventario.inventarioApp.service;

import com.app.inventario.inventarioApp.exception.ProductoNotFoundException;
import com.app.inventario.inventarioApp.model.Producto;
import com.app.inventario.inventarioApp.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> obtenerTodosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new ProductoNotFoundException("Producto no encontrado con el ID: " + id));
    }

    @Override
    public Producto actualizarProducto(Long id, Producto producto) {
        Producto productoExistente = obtenerProductoPorId(id);
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setCantidad(producto.getCantidad());
        productoExistente.setCategoria(producto.getCategoria());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setPrecio(producto.getPrecio());
        return productoRepository.save(productoExistente);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
