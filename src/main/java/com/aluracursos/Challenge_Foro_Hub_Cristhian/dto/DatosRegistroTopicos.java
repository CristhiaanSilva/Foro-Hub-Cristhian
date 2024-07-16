package com.aluracursos.Challenge_Foro_Hub_Cristhian.dto;

import com.aluracursos.Challenge_Foro_Hub_Cristhian.model.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopicos(@NotBlank
                                   String titulo,
                                   @NotBlank
                                   String mensaje,
                                   @NotNull @Valid
                                   Curso curso) {
}
