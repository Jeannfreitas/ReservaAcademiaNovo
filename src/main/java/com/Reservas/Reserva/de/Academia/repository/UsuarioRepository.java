package com.Reservas.Reserva.de.Academia.repository;

import com.Reservas.Reserva.de.Academia.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}