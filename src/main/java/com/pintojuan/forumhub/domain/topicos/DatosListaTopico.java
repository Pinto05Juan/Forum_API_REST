package com.pintojuan.forumhub.domain.topicos;

import com.pintojuan.forumhub.domain.usuarios.DatosUsuario;

import java.time.LocalDateTime;

public record DatosListaTopico(
        String titulo,
        String mensaje,
        LocalDateTime fecha_creacion,
        Boolean estado,
        DatosUsuario autor,
        String curso
) {

    public DatosListaTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getEstado(),
                new DatosUsuario(topico.getAutor()),
                topico.getCurso()
                );
    }
}
