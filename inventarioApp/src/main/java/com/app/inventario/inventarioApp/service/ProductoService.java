package com.app.inventario.inventarioApp.service;

import com.app.inventario.inventarioApp.model.Producto;

import java.util.List;

public interface ProductoService {
    Producto guardarProducto(Producto producto);
    List<Producto> obtenerTodosProductos();
    Producto obtenerProductoPorId(Long id);
    Producto actualizarProducto(Long id, Producto producto);
    void eliminarProducto(Long id);
}
