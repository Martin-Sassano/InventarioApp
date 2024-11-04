package com.app.inventario.inventarioApp.mapper;

import com.app.inventario.inventarioApp.dto.ProductoDTO;
import com.app.inventario.inventarioApp.model.Producto;

public class ProductoMapper {

    public static ProductoDTO toDto(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setCantidad(producto.getCantidad());
        dto.setCategoria(producto.getCategoria());
        return dto;
    }

    public static Producto toEntity(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setCantidad(dto.getCantidad());
        producto.setCategoria(dto.getCategoria());
        return producto;
    }
}
