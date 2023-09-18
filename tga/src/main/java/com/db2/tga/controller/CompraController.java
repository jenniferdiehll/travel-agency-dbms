package com.db2.tga.controller;

import com.db2.tga.models.Compra;
import com.db2.tga.models.Reserva;
import com.db2.tga.models.Ticket;
import com.db2.tga.repository.CompraRepository;
import com.db2.tga.repository.ReservaRepository;
import com.db2.tga.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @PostMapping
    public ResponseEntity<Compra> registrarCompra(@RequestBody Compra compra) {
        Compra novaCompra = compraRepository.save(compra);

        List<Ticket> tickets = gerarTicketsParaCompra(novaCompra);

        for (Ticket ticket : tickets) {
            ticketRepository.save(ticket);
        }

        novaCompra.setTickets(tickets);
        novaCompra = compraRepository.save(novaCompra);

        return new ResponseEntity<>(novaCompra, HttpStatus.CREATED);
    }

    @PostMapping("/ticket/{ticketId}")
    public ResponseEntity<Reserva> criarReserva(@PathVariable int ticketId, @RequestBody Reserva reserva) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);

        if (ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();
            reserva.setTicket(ticket);

            Reserva novaReserva = reservaRepository.save(reserva);
            return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private List<Ticket> gerarTicketsParaCompra(Compra compra) {
        List<Ticket> tickets = new ArrayList<>();

        Ticket ticket = new Ticket();
        ticket.setCompra(compra);

        tickets.add(ticket);
        return tickets;
    }
}
