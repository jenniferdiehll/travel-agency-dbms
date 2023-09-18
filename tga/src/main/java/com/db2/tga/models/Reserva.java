package com.db2.tga.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Reserva")
public class Reserva {

    @Id
    private int idTicket;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idTicket")
    private Ticket ticket;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataInicial")
    private Date dataInicial;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataFinal")
    private Date dataFinal;

    @Column(name = "status")
    private String status;
}
