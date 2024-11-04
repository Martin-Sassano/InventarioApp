package com.app.inventario.inventarioApp.config;

import com.app.inventario.inventarioApp.model.Producto;
import com.app.inventario.inventarioApp.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner cargarDatos(ProductoRepository productoRepository) {
        return args -> {
            // Verificamos si la base de datos está vacía antes de cargar los productos de ejemplo
            if (productoRepository.count() == 0) {
                // Crear algunos productos por defecto
                Producto producto1 = new Producto("Laptop", BigDecimal.valueOf(1200.50), 10);
                Producto producto2 = new Producto("Mouse", BigDecimal.valueOf(25.75), 50);
                Producto producto3 = new Producto("Teclado Mecánico", BigDecimal.valueOf(89.99), 30);
                Producto producto4 = new Producto("Monitor 4K", BigDecimal.valueOf(300.00), 15);
                Producto producto5 = new Producto("Escritorio", BigDecimal.valueOf(150.00), 5);

                // Guardar los productos en la base de datos
                productoRepository.saveAll(Arrays.asList(producto1, producto2, producto3, producto4, producto5));

                System.out.println("Productos de ejemplo cargados en la base de datos.");
            }
        };
    }
}