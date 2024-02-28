package com.project_service.project_service.repository;

import com.project_service.project_service.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
    Usuario findByEmail(String email);
}