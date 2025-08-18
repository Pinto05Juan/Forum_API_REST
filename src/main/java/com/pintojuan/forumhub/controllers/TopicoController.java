package com.pintojuan.forumhub.controllers;

import com.pintojuan.forumhub.domain.topicos.DatosDetalleTopico;
import com.pintojuan.forumhub.domain.topicos.DatosRegistroTopico;
import com.pintojuan.forumhub.domain.topicos.Topico;
import com.pintojuan.forumhub.domain.topicos.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder) {
        var topico = new Topico(datos);
        repository.save(topico);

        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }
}
