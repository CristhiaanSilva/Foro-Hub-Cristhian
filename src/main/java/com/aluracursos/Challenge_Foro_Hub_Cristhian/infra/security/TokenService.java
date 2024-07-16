package com.aluracursos.Challenge_Foro_Hub_Cristhian.infra.security;

import com.aluracursos.Challenge_Foro_Hub_Cristhian.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static com.auth0.jwt.JWT.require;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("Foro Hub Cristhian")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(fechaDeExpiracion())
                    .sign(algoritmo);
        } catch (JWTCreationException jwtCreationException) {
            throw new RuntimeException("Lo sentimos, ha ocurrido un error al generar al token", jwtCreationException);
        }
    }

    public String getSubject(String token) {
        if (token == null){
            throw new RuntimeException();
        }
        DecodedJWT verifier = null;
        try {
            Algorithm algoritmo = Algorithm.HMAC256(apiSecret);
            verifier = require(algoritmo).withIssuer("Foro Hub Cristhian")
                    .build()
                    .verify(token);
            verifier.getSubject();
        } catch (JWTVerificationException exception) {
            System.out.println(exception.toString());
        }
        if (verifier.getSubject() == null){
            throw new RuntimeException("El token es invalido o ha expirado");

        }
        return verifier.getSubject();
    }

    private Instant fechaDeExpiracion() {
        return LocalDateTime.now().plusHours(4).toInstant(ZoneOffset.of("-06:00"));
    }
}