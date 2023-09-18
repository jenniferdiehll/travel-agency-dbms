package com.db2.tga.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Voo")
public class Voo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVoo;

    @ManyToMany(mappedBy = "voos")
    private List<Viagem> viagens;

    @ManyToOne
    @JoinColumn(name = "idAviao")
    private Aviao idAviao;

    private String localizador;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Column(name = "origem")
    private String origem;

    @Column(name = "destino")
    private String destino;

}
