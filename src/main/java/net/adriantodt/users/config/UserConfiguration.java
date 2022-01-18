package net.adriantodt.users.config;

import lombok.RequiredArgsConstructor;
import net.adriantodt.users.model.User;
import net.adriantodt.users.model.UserProfile;
import net.adriantodt.users.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class UserConfiguration {
    private final UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        if (userRepository.count() == 0) {
            final var user = new User(
                null,
                "Administrator",
                "admin@example.com",
                passwordEncoder().encode("adminadmin"),
                null,
                null,
                UserProfile.ADMIN
            );

            userRepository.insert(user);
        }
    }
}
