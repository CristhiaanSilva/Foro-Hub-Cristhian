package com.aluracursos.Challenge_Foro_Hub_Cristhian.dto;

import com.aluracursos.Challenge_Foro_Hub_Cristhian.model.Curso;
import com.aluracursos.Challenge_Foro_Hub_Cristhian.model.Topico;

import java.time.LocalDateTime;

public record DatosDetallesTopicos(String titulo, String mensaje, LocalDateTime fechaCreacion, Curso curso) {
    public DatosDetallesTopicos(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getCurso());
    }
}
