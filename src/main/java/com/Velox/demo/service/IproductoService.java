package com.Velox.demo.service;

import com.Velox.demo.model.producto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IproductoService {
    List<producto> obtenerTodos();

    Optional<producto> TraerPorId(Long id_producto);

    producto agregarProducto(producto producto);

    void eliminarProducto(Long id_producto);

    void actualizarProducto(Long id_producto, producto prodActualizado);
}
