package com.pintojuan.forumhub.domain.topicos;


import com.pintojuan.forumhub.domain.usuarios.DatosUsuario;

public record DatosActualizarTopico(
        String titulo,
        String mensaje,
        String curso,
        DatosUsuario usuario
) {
}
