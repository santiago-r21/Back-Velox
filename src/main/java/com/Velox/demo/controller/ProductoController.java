package com.Velox.demo.controller;

import com.Velox.demo.model.producto;
import com.Velox.demo.service.IproductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")

public class ProductoController {
    private final IproductoService iproductoService;

    public ProductoController(IproductoService iproductoService) {
        this.iproductoService = iproductoService;
    }

    @GetMapping
    public List<producto>listaProductos(){
        return iproductoService.obtenerTodos();
    }

    @GetMapping("/{id_producto}")
    public producto obtenerPorId(@PathVariable Long id_producto ){
    return iproductoService.TraerPorId(id_producto)
            .orElseThrow(()->new RuntimeException("No se encontro el Producto con id: "+id_producto));
    }

    @PostMapping("/crear")
    public producto crearProducto(@RequestBody producto producto){
        return iproductoService.agregarProducto(producto);
    }

    @DeleteMapping("/borrar/{id_producto}")
    public ResponseEntity<String>borrarProducto(@PathVariable Long id_producto){
        iproductoService.eliminarProducto(id_producto);
        return ResponseEntity.ok("El producto fue eliminado exitosamente");
    }
    @PutMapping("/actualizar/{id_producto}")
    public ResponseEntity<String>actProducto(@PathVariable Long id_prodcuto, @RequestBody producto prodActualizado){
        iproductoService.actualizarProducto(id_prodcuto,prodActualizado);
        return ResponseEntity.ok("Se actualizo el producto correctamente ");
    }
}
