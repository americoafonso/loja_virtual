package com.lojavirtual.loja_virtual.security;

import com.lojavirtual.loja_virtual.AplicationContextLoad;
import com.lojavirtual.loja_virtual.model.Usuario;
import com.lojavirtual.loja_virtual.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Service
public class JWTTokenAutenticacaoService {

    // Token de validade de 11 dias
    private static final long EXPIRATION_TIME = 959990000;

    /*Chave de senha para juntar com o JWT*/
    private static final String SECRET = "ss/-*-*sds565dsd-s/d-s*dsds";

    // Chave de senha para juntar com jwt
    private static final String TOKEN_PREFIX = "Bearer";

    private static final String HEADER_STRING = "Authorization";

    // Gera o token e da a resposta para o cliente com JWT
    public void addAthentication(HttpServletResponse response, String username) throws Exception {

        String JWT = Jwts.builder() // chama o gerador de token
                .setSubject(username) // Adiciona o user
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact(); /*Temp de expiração*/

        String token = TOKEN_PREFIX + " " + JWT;

        // Da a resposta pra tela e para o cliente, ex: outra api, navegador, outra chamada qualquer...
        response.addHeader(HEADER_STRING, token);

        liberacaoCors(response);

        // Usado para ver no Postman para teste
        response.getWriter().write("{\"Authorization\": \"" + token + "\"}");
    }

    public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            String tokenLimpo = token.replace(TOKEN_PREFIX, "").trim();

            String user = Jwts.parser().
                    setSigningKey(SECRET)
                    .parseClaimsJws(tokenLimpo)
                    .getBody().getSubject(); /*ADMIN ou Americo*/

            if (user != null) {
                Usuario usuario = AplicationContextLoad
                        .getApplicationContext()
                        .getBean(UsuarioRepository.class).findUserByLogin(user);

                if (usuario != null) {
                    return new UsernamePasswordAuthenticationToken(
                            usuario.getLogin(),
                            usuario.getSenha(),
                            usuario.getAuthorities());
                }
            }
        }
        liberacaoCors(response);
        return null;
    }

    // Fazendo liberacao contra erro de cors no navegador
    private void liberacaoCors(HttpServletResponse response) {
        if (response.getHeader("Access-Control-Allow-Origin") == null) {
            response.addHeader("Access-Control-Allow-Origin", "*");
        }
        if (response.getHeader("Access-Control-Allow-Headers") == null) {
            response.addHeader("Access-Control-Allow-Headers", "*");
        }
        if (response.getHeader("Access-Control-Request-Headers") == null) {
            response.addHeader("Access-Control-Request-Headers", "*");
        }
        if (response.getHeader("Access-Control-Allow-Methods") == null) {
            response.addHeader("Access-Control-Allow-Methods", "*");
        }
    }

}
