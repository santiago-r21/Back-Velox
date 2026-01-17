package com.Velox.demo.controller;

import com.Velox.demo.model.Usuario;
import com.Velox.demo.repository.IusuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // Esto hace que esta clase responda a peticiones web (API)
    @RequestMapping("/usuarios") // La URL base: http://localhost:8080/api/usuarios
    @CrossOrigin(origins = "*") // IMPORTANTE: Permite que tu archivo HTML hable con Java

    public class UsuarioController {
        @Autowired // Conecta automáticamente el repositorio
        private IusuarioRepository iusuarioRepository;

        // 1. OBTENER TODOS LOS USUARIOS (GET)
        @GetMapping
        public List<Usuario> getAllUsuarios() {
            System.out.println("➡️ [BACKEND] Petición recibida: Listar usuarios");
            return iusuarioRepository.findAll();
        }

        // 2. CREAR USUARIO (POST)
        @PostMapping("/crear")
        public Usuario createUsuario(@RequestBody Usuario usuario) {
            System.out.println("➡️ [BACKEND] Creando usuario: " + usuario.getEmail());
            return iusuarioRepository.save(usuario);
        }

        // 3. ELIMINAR USUARIO (DELETE)
        @DeleteMapping("/eliminar/{id}")
        public ResponseEntity<String> deleteUsuario(@PathVariable Long id) {
            System.out.println("➡️ [BACKEND] Eliminando usuario ID: " + id);
            if(iusuarioRepository.existsById(id)){
                iusuarioRepository.deleteById(id);
                return ResponseEntity.ok("Se elimino correctamente el usuario");
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        // 4. ACTUALIZAR USUARIO (PUT)
        @PutMapping("uptUser/{id}")
        public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
            System.out.println("➡️ [BACKEND] Actualizando usuario ID: " + id);
            return iusuarioRepository.findById(id)
                    .map(usuario -> {
                        usuario.setEmail(usuarioDetails.getEmail());
                        usuario.setNombre(usuarioDetails.getNombre());
                        usuario.setApellido(usuarioDetails.getApellido());
                        // Solo actualizamos clave si viene vacía
                        if(usuarioDetails.getClave() != null && !usuarioDetails.getClave().isEmpty()) {
                            usuario.setClave(usuarioDetails.getClave());
                        }
                        usuario.setRol(usuarioDetails.getRol());
                        usuario.setDireccion(usuarioDetails.getDireccion());

                        Usuario updatedUsuario = iusuarioRepository.save(usuario);
                        return ResponseEntity.ok().body(updatedUsuario);
                    })
                    .orElse(ResponseEntity.notFound().build());
        }
    }

