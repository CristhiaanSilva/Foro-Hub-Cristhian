package com.aluracursos.Challenge_Foro_Hub_Cristhian.dto;

import com.aluracursos.Challenge_Foro_Hub_Cristhian.model.Curso;
import com.aluracursos.Challenge_Foro_Hub_Cristhian.model.Topico;

public record DatosListaTopicos(Long id, String titulo, String mensaje, Curso curso) {
    public DatosListaTopicos(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getCurso());
    }
}
