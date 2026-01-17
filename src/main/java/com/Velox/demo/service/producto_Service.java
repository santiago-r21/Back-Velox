package com.Velox.demo.service;

import com.Velox.demo.model.producto;
import com.Velox.demo.repository.IproductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class producto_Service implements IproductoService {
    private final IproductoRepository iproductoRepository;

    public producto_Service(IproductoRepository iproductoRepository) {
        this.iproductoRepository = iproductoRepository;
    }
    //traer todos los productos
    @Transactional(readOnly = true)
    @Override
    public List<producto>obtenerTodos(){
        return iproductoRepository.findAll();
    }



    //traer por id
    @Transactional(readOnly = true)
    @Override
    public Optional<producto>TraerPorId(Long id_producto){
        producto producto=iproductoRepository.findById(id_producto)
                .orElseThrow(()->new RuntimeException("NO se encontro el Producto con id: "+id_producto));
        return Optional.of(producto);
    }
    //insertar en la BD
    @Override
    public producto agregarProducto(producto producto){
        return iproductoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id_producto){
        iproductoRepository.deleteById(id_producto);
    }
    @Override
    public void actualizarProducto(Long id_producto, producto prodActualizado){
        producto encontrado=iproductoRepository.findById(id_producto).orElse(null);
        if (encontrado!=null){
            encontrado.setNombre(prodActualizado.getNombre());
            encontrado.setDescripcion(prodActualizado.getDescripcion());
            encontrado.setPrecio(prodActualizado.getPrecio());
            encontrado.setStock(prodActualizado.getStock());
            encontrado.setImagen(prodActualizado.getImagen());
        }else{
            throw new RuntimeException("No se encontro el producto");
        }
    }

}
