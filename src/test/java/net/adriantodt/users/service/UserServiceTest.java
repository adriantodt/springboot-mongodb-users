package net.adriantodt.users.service;

import net.adriantodt.users.model.User;
import net.adriantodt.users.model.UserProfile;
import net.adriantodt.users.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Test
    void saveUser(@Mock UserRepository repository) {
        when(repository.save(any(User.class))).then(i -> {
            final var user = i.getArgument(0, User.class);
            if (user.getId() == null) {
                user.setId(UUID.randomUUID().toString());
            }
            return user;
        });

        UserService service = new UserService(repository, new BCryptPasswordEncoder());

        User user = new User(
            null,
            "Administrator",
            "admin@example.com",
            "adminadmin",
            null,
            null,
            UserProfile.ADMIN
        );

        final var savedUser = service.saveUser(user);

//        Assertions.assertEquals();
    }

    @Test
    void findUsers() {
    }

    @Test
    void getByEmail() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void getById() {
    }
}
