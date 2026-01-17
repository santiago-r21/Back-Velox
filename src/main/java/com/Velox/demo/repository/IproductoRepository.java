package com.Velox.demo.repository;

import com.Velox.demo.model.producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IproductoRepository extends JpaRepository<producto, Long> {
}
