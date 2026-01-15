package com.Velox.demo.repository;

import com.Velox.demo.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IusuarioRepository extends JpaRepository<usuario, Integer> {
}
