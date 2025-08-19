package com.pintojuan.forumhub.domain.topicos;

import com.pintojuan.forumhub.domain.usuarios.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo; //asunto
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaDeCreacion;
    private String curso;
    private Boolean estado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    public Topico(DatosRegistroTopico datos) {
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaDeCreacion = LocalDateTime.now();
        this.curso = datos.curso();
        this.autor = new Usuario(datos.autor());
    }

    public void actualizarInformacion(@Valid DatosActualizarTopico datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }

        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }

        if (datos.curso() != null) {
            this.curso= datos.curso();
        }

        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }

        if (datos.usuario() != null) {
            this.autor = new Usuario(datos.usuario());
        }
    }
}
