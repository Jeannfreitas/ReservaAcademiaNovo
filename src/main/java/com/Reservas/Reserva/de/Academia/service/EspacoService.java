package com.Reservas.Reserva.de.Academia.service;

import com.Reservas.Reserva.de.Academia.model.Espaco;
import com.Reservas.Reserva.de.Academia.repository.EspacoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspacoService {

    private final EspacoRepository espacoRepository;

    public EspacoService(EspacoRepository espacoRepository) {
        this.espacoRepository = espacoRepository;
    }

    public Espaco salvar(Espaco espaco) {
        return espacoRepository.save(espaco);
    }

    public Optional<Espaco> buscarPorId(Long id) {
        return espacoRepository.findById(id);
    }

    public List<Espaco> listarTodos() {
        return espacoRepository.findAll();
    }

    public void deletar(Long id) {
        espacoRepository.deleteById(id);
    }
}