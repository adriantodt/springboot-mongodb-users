package net.adriantodt.users.service;

import lombok.RequiredArgsConstructor;
import net.adriantodt.users.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserBasedDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user with email '" + username + "'");
        }
        return new org.springframework.security.core.userdetails.User(
            user.getEmail(), user.getSenha(), Collections.singletonList(user.getPerfil())
        );
    }
}
