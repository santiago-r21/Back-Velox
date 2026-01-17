package com.Velox.demo.repository;


import com.Velox.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IusuarioRepository extends JpaRepository<Usuario, Long> {
}
