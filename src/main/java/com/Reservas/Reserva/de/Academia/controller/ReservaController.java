package com.Reservas.Reserva.de.Academia.controller;

import com.Reservas.Reserva.de.Academia.model.Atividade;
import com.Reservas.Reserva.de.Academia.model.Reserva;
import com.Reservas.Reserva.de.Academia.model.Usuario;
import com.Reservas.Reserva.de.Academia.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<Reserva> reservar(@RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.reservar(reserva));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarPorId(@PathVariable Long id) {
        return reservaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Reserva> listarPorUsuario(@PathVariable Long usuarioId) {
        Usuario u = new Usuario();
        u.setId(usuarioId);
        return reservaService.listarPorUsuario(u);
    }

    @GetMapping("/atividade/{atividadeId}")
    public List<Reserva> listarPorAtividade(@PathVariable Long atividadeId) {
        Atividade a = new Atividade();
        a.setId(atividadeId);
        return reservaService.listarPorAtividade(a);
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        reservaService.cancelarReserva(id);
        return ResponseEntity.noContent().build();
    }
}