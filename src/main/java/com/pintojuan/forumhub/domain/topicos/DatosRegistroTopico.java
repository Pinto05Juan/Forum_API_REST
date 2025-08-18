package com.pintojuan.forumhub.domain.topicos;


import com.pintojuan.forumhub.domain.usuarios.DatosUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull @Valid DatosUsuario autor,
        @NotBlank String curso
) {
}
