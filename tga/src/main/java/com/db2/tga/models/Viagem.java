package com.db2.tga.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Viagem")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idViagem;

    @ManyToMany
    @JoinTable(
            name = "viagem_voo",
            joinColumns = @JoinColumn(name = "viagem_id"),
            inverseJoinColumns = @JoinColumn(name = "voo_id")
    )
    private List<Voo> voos;

    @Column(name = "origem")
    private String origem;

    @Column(name = "destino")
    private String destino;

}
