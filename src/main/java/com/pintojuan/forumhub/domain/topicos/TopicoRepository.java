package com.pintojuan.forumhub.domain.topicos;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    boolean existsById(Long id);

    @Override
    Optional<Topico> findById(Long id);
}
