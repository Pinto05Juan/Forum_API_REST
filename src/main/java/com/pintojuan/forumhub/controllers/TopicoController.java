package com.pintojuan.forumhub.controllers;

import com.pintojuan.forumhub.domain.topicos.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder) {
        if(repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            return ResponseEntity.badRequest().body("Ya existe un topico con ese titulo y mensaje");
        }
        var topico = new Topico(datos);
        repository.save(topico);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datos) {
        var topico = repository.getReferenceById(id);
        topico.actualizarInformacion(datos);
        return ResponseEntity.ok().body(new DatosDetalleTopico(topico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id) {
        var topico = repository.findById(id);
        if (topico.isPresent()) {
            repository.deleteById(id);
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity listar() {
        var topicos = repository.findAll().stream().map(DatosListaTopico::new);
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id) {
        if(!repository.existsById(id)) {
            return ResponseEntity.badRequest().body("ID invalido o no encontrado");
        }
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }
}
