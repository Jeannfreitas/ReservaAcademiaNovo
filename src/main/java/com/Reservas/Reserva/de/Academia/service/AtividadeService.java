package com.Reservas.Reserva.de.Academia.service;

import com.Reservas.Reserva.de.Academia.model.Atividade;
import com.Reservas.Reserva.de.Academia.repository.AtividadeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    private final AtividadeRepository atividadeRepository;

    public AtividadeService(AtividadeRepository atividadeRepository) {
        this.atividadeRepository = atividadeRepository;
    }

    public Atividade salvar(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    public Optional<Atividade> buscarPorId(Long id) {
        return atividadeRepository.findById(id);
    }

    public List<Atividade> listarTodas() {
        return atividadeRepository.findAll();
    }

    public List<Atividade> buscarPorHorario(LocalDateTime inicio, LocalDateTime fim) {
        return atividadeRepository.findByHorarioBetween(inicio, fim);
    }

    public void deletar(Long id) {
        atividadeRepository.deleteById(id);
    }
}