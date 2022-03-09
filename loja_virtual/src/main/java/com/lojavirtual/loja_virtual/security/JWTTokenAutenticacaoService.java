package com.lojavirtual.loja_virtual.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.security.KeyRep.Type.SECRET;

@Service
public class JWTTokenAutenticacaoService {

    // Token de validade de 11 dias
    private static final long EXPIRATION_TIME = 959990000;

    // Chave de senha para juntar com jwt
    private static final String TOKEN_PREFIX = "Bearer";

    private static final String HEADER_STRING = "Authorization";

    // Gera o token e da a resposta para o cliente com JWT
    public void addAthentication(HttpServletResponse response, String username) throws Exception {

        String JWT = Jwts.builder() // chama o gerador de token
                .setSubject(username) // Adiciona o user
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, String.valueOf(SECRET)).compact(); // Tempo de expiracao

        String token = TOKEN_PREFIX + " " + JWT;

        // Da a resposta pra tela e para o cliente, ex: outra api, navegador, outra chamada qualquer...
        response.addHeader(HEADER_STRING, token);

        // Usado para ver no Postman para teste
        response.getWriter().write("{\"Authorization\": \"" + token + "\"}");

    }

}
