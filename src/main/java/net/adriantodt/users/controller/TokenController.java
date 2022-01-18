package net.adriantodt.users.controller;

import lombok.RequiredArgsConstructor;
import net.adriantodt.users.dto.AuthRequestDto;
import net.adriantodt.users.dto.AuthResponseDto;
import net.adriantodt.users.exceptions.UnauthorizedException;
import net.adriantodt.users.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
public class TokenController {
    private final UserService userService;
    private final JwtEncoder encoder;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/auth")
    public AuthResponseDto auth(@RequestBody AuthRequestDto body) {
        final var user = userService.getByEmail(body.getEmail());

        if (user == null || !passwordEncoder.matches(body.getPassword(), user.getSenha())) {
            throw new UnauthorizedException();
        }

        Instant now = Instant.now();
        long expiry = 36000L;
        JwtClaimsSet claims = JwtClaimsSet.builder()
            .issuer("self")
            .issuedAt(now)
            .expiresAt(now.plusSeconds(expiry))
            .subject(user.getEmail())
            .claim("scope", user.getPerfil().getAuthority())
            .build();
        final var token = this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new AuthResponseDto(token);
    }
}
