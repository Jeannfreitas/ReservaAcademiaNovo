package com.Reservas.Reserva.de.Academia.repository;

import com.Reservas.Reserva.de.Academia.model.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
    List<Atividade> findByHorarioBetween(LocalDateTime inicio, LocalDateTime fim);
}