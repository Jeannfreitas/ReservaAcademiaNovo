package com.Reservas.Reserva.de.Academia.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "espaco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Espaco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @OneToMany(mappedBy = "espaco", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atividade> atividades;
}