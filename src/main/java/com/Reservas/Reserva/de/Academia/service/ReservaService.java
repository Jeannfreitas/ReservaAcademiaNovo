package com.Reservas.Reserva.de.Academia.service;

import com.Reservas.Reserva.de.Academia.enums.StatusReserva;
import com.Reservas.Reserva.de.Academia.model.Atividade;
import com.Reservas.Reserva.de.Academia.model.Reserva;
import com.Reservas.Reserva.de.Academia.model.Usuario;
import com.Reservas.Reserva.de.Academia.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva reservar(Reserva reserva) {
        // regra extra: não permitir reservas duplicadas para mesmo usuário na mesma atividade
        List<Reserva> reservasExistentes = reservaRepository.findByAtividade(reserva.getAtividade());
        boolean jaReservado = reservasExistentes.stream()
                .anyMatch(r -> r.getUsuario().getId().equals(reserva.getUsuario().getId())
                        && r.getStatus() == StatusReserva.CONFIRMADA);

        if (jaReservado) {
            throw new RuntimeException("Usuário já possui reserva nesta atividade!");
        }

        // regra extra: verificar se ainda há vagas
        long confirmadas = reservasExistentes.stream()
                .filter(r -> r.getStatus() == StatusReserva.CONFIRMADA)
                .count();

        if (confirmadas >= reserva.getAtividade().getCapacidade()) {
            throw new RuntimeException("Capacidade máxima atingida para esta atividade!");
        }

        return reservaRepository.save(reserva);
    }

    public Optional<Reserva> buscarPorId(Long id) {
        return reservaRepository.findById(id);
    }

    public List<Reserva> listarPorUsuario(Usuario usuario) {
        return reservaRepository.findByUsuario(usuario);
    }

    public List<Reserva> listarPorAtividade(Atividade atividade) {
        return reservaRepository.findByAtividade(atividade);
    }

    public void cancelarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        reserva.setStatus(StatusReserva.CANCELADA);
        reservaRepository.save(reserva);
    }
}