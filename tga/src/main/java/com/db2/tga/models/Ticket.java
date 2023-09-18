package com.db2.tga.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTicket;

    @ManyToOne
    @JoinColumn(name = "idCompra")
    private Compra compra;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    private Reserva reserva;
}
