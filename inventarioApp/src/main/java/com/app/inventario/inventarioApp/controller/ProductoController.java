package com.app.inventario.inventarioApp.controller;

import com.app.inventario.inventarioApp.dto.ProductoDTO;
import com.app.inventario.inventarioApp.mapper.ProductoMapper;
import com.app.inventario.inventarioApp.model.Producto;
import com.app.inventario.inventarioApp.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

//    @PostMapping
//    public Producto crearProducto(@RequestBody Producto producto){
//        return productoService.guardarProducto(producto);
//    }

    @PostMapping
    public ProductoDTO crearProducto(@RequestBody @Valid ProductoDTO productoDTO) {
        Producto producto = ProductoMapper.toEntity(productoDTO);
        return ProductoMapper.toDto(productoService.guardarProducto(producto));
    }

//    @GetMapping
//    public List<Producto> obtenerProductos(){
//        return productoService.obtenerTodosProductos();
//    }

    @GetMapping
    public List<ProductoDTO> obtenerProductos() {
        return productoService.obtenerTodosProductos().stream()
                .map(ProductoMapper::toDto)
                .collect(Collectors.toList());
    }

//    @GetMapping("/{id}")
//    public Producto obtenerProductoPorId(@PathVariable Long id){
//        return productoService.obtenerProductoPorId(id);
//    }

    @GetMapping("/{id}")
    public ProductoDTO obtenerProductoPorId(@PathVariable Long id) {
        Producto producto = productoService.obtenerProductoPorId(id);
        return ProductoMapper.toDto(producto);
    }

//    @PutMapping("/editar/{id}")
//    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto){
//        return productoService.actualizarProducto(id, producto);
//    }

    @PutMapping("/{id}")
    public ProductoDTO actualizarProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        Producto producto = ProductoMapper.toEntity(productoDTO);
        Producto productoActualizado = productoService.actualizarProducto(id, producto);
        return ProductoMapper.toDto(productoActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable Long id){
        productoService.eliminarProducto(id);
    }
}
