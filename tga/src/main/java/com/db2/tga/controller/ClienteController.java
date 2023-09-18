package com.db2.tga.controller;

import com.db2.tga.models.Cliente;
import com.db2.tga.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    public ResponseEntity<String> cadastrarCliente(@RequestBody Cliente cliente) {
        repository.save(cliente);
        return ResponseEntity.ok("Cliente cadastrado com sucesso!");
    }

    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

}
