package com.Reservas.Reserva.de.Academia.controller;

import com.Reservas.Reserva.de.Academia.model.Espaco;
import com.Reservas.Reserva.de.Academia.service.EspacoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/espacos")
public class EspacoController {

    private final EspacoService espacoService;

    public EspacoController(EspacoService espacoService) {
        this.espacoService = espacoService;
    }

    @PostMapping
    public ResponseEntity<Espaco> salvar(@RequestBody Espaco espaco) {
        return ResponseEntity.ok(espacoService.salvar(espaco));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Espaco> buscarPorId(@PathVariable Long id) {
        return espacoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Espaco> listarTodos() {
        return espacoService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        espacoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}