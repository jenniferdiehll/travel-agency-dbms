package com.db2.tga.controller;

import com.db2.tga.models.Aviao;
import com.db2.tga.models.Viagem;
import com.db2.tga.models.Voo;
import com.db2.tga.repository.AviaoRepository;
import com.db2.tga.repository.ViagemRepository;
import com.db2.tga.repository.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viagem")
public class ViagemController {

    @Autowired
    private AviaoRepository aviaoRepository;

    @Autowired
    private VooRepository vooRepository;

    @Autowired
    private ViagemRepository viagemRepository;


    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarViagem(@RequestBody Viagem viagem) {
        viagemRepository.save(viagem);
        return ResponseEntity.ok("Viagem cadastrada com sucesso!");
    }

    @PostMapping("/aviao")
    public ResponseEntity<String> cadastrarAviao(@RequestBody Aviao aviao) {
        aviaoRepository.save(aviao);
        return ResponseEntity.ok("Avião cadastrado com sucesso!");
    }

    @PostMapping("/voo")
    public ResponseEntity<String> cadastrarVoo(@RequestBody Voo voo) {
        vooRepository.save(voo);
        return ResponseEntity.ok("Voo cadastrado com sucesso!");
    }

}
