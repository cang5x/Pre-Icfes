package com.icfesia.backend.repository;


import com.icfesia.backend.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Ejemplo de método extra:
    // Optional<Usuario> findByEmail(String email);
}
