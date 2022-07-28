package org.example.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

    @Value("${token.access-expired-time}")
    private long ACCESS_EXPIRED_TIME;

    @Value("${token.refresh-expired-time}")
    private long REFRESH_EXPIRED_TIME;

    @Value("${token.secret}")
    private String SECRET;

    public String createJwtAccessToken(String userId, String uri, List<String> roles) {
        Claims claims = Jwts.claims()
                            .setSubject(userId);
        claims.put("roles", roles);

        return Jwts.builder()
                   .addClaims(claims)
                   .setExpiration(
                       new Date(System.currentTimeMillis() + ACCESS_EXPIRED_TIME)
                   )
                   .setIssuedAt(new Date())
                   .signWith(SignatureAlgorithm.HS512, SECRET)
                   .setIssuer(uri)
                   .compact();
    }
}
