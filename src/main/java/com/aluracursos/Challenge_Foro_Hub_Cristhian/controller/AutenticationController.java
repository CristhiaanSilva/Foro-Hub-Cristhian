package com.aluracursos.Challenge_Foro_Hub_Cristhian.controller;

import com.aluracursos.Challenge_Foro_Hub_Cristhian.dto.DatosAutentication;
import com.aluracursos.Challenge_Foro_Hub_Cristhian.dto.DatosToken;
import com.aluracursos.Challenge_Foro_Hub_Cristhian.infra.security.TokenService;
import com.aluracursos.Challenge_Foro_Hub_Cristhian.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutentication datosAutenticacion) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(datosAutenticacion.login(), datosAutenticacion.password());
        var autenticacion = authenticationManager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generarToken((Usuario) autenticacion.getPrincipal());
        return ResponseEntity.ok(new DatosToken(tokenJWT));
    }
}
