package com.db2.tga.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true, name = "cpf")
    private String cpf;

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataNascimento")
    private Date dataNascimento;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compra> compras;
}
