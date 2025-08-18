package com.pintojuan.forumhub.domain.usuarios;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String password;

    public Usuario(DatosUsuario datos) {
        this.id = datos.id();
        this.nombre = datos.nombre();
        this.email = null;
        this.password = null;
    }
}
