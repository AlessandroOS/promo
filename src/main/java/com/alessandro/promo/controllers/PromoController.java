package com.alessandro.promo.controllers;

import com.alessandro.promo.models.Promo;
import com.alessandro.promo.services.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/ofertas")
public class PromoController {

    @Autowired
    PromoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Promo> findById(@PathVariable Long id)  {
        Promo promo = service.findById(id);
        return ResponseEntity.ok().body(promo);
    }

    @GetMapping
    public ResponseEntity<Page<Promo>> findAll(@PageableDefault(size = 5) Pageable pageable) {
        Page<Promo> listaPromos = service.findAll(pageable);
        return ResponseEntity.ok().body(listaPromos);
    }

    @PostMapping
    public ResponseEntity<Promo> cadastrar(@RequestBody @Valid Promo promo) {
        promo = service.Cadastrar(promo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(promo.getId()).toUri();
        return ResponseEntity.created(uri).body(promo);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Promo> update(@PathVariable Long id, @RequestBody Promo promo) {
        promo = service.update(id, promo);
        return ResponseEntity.ok().body(promo);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<Promo>> findByDescricao(@RequestParam(required = false) String descricao)  {
        return ResponseEntity.ok(service.findByDescricao(descricao));
    }
}
