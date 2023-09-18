package com.db2.tga.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Aviao")
public class Aviao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAviao;

    @Column(name = "ciaAerea")
    private String ciaAerea;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "quantidadeLugares")
    private String quantidadeLugares;
}
