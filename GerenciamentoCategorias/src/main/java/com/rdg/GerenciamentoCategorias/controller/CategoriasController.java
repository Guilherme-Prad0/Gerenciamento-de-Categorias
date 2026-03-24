package com.rdg.GerenciamentoCategorias.controller;


import com.rdg.GerenciamentoCategorias.models.CategoriasModel;
import com.rdg.GerenciamentoCategorias.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriasService;

    @GetMapping
    public ResponseEntity<List<CategoriasModel>> getAll() {
        List<CategoriasModel> categorias = categoriasService.findAll();
        return ResponseEntity.ok(categorias);
    }

    @PostMapping
    public ResponseEntity<CategoriasModel> create(@RequestBody CategoriasModel categorias) {
        CategoriasModel categoriaSalva = categoriasService.save(categorias);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoriaSalva.getId())
                .toUri();

        return ResponseEntity.created(uri).body(categoriaSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoriasService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CategoriasModel categorias) {
        categoriasService.update(id, categorias);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriasModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriasService.findById(id));
    }
}
