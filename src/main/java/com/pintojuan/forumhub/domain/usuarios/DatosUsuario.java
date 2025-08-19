package com.pintojuan.forumhub.domain.usuarios;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosUsuario(
        @NotNull Long id,
        @NotBlank String nombre
) {

    public DatosUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre());
    }
}
