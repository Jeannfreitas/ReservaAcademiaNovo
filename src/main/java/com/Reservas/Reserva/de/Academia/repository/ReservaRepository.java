package com.Reservas.Reserva.de.Academia.repository;


import com.Reservas.Reserva.de.Academia.model.Atividade;
import com.Reservas.Reserva.de.Academia.model.Reserva;
import com.Reservas.Reserva.de.Academia.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByUsuario(Usuario usuario);

    List<Reserva> findByAtividade(Atividade atividade);
}
