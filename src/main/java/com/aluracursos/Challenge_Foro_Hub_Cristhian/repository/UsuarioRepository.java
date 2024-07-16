package com.aluracursos.Challenge_Foro_Hub_Cristhian.repository;

import com.aluracursos.Challenge_Foro_Hub_Cristhian.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String login);
}
