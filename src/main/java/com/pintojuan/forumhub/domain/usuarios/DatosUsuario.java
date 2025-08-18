package com.pintojuan.forumhub.domain.usuarios;

import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(
        @NotBlank Long id,
        @NotBlank String nombre
) {
}
