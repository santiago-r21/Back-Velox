package com.Velox.demo.repository;

import com.Velox.demo.model.pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IpedidoRepository extends JpaRepository<pedido, Integer> {
}
