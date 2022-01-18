package net.adriantodt.users.controller;

import lombok.RequiredArgsConstructor;
import net.adriantodt.users.dto.UserRequestDto;
import net.adriantodt.users.dto.UserResponseDto;
import net.adriantodt.users.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping()
    public UserResponseDto create(@RequestBody UserRequestDto body) {
        final var user = body.toUser();
        return new UserResponseDto(this.userService.saveUser(user));
    }

    @PutMapping("/{id}")
    private UserResponseDto put(@PathVariable("id") String id, @RequestBody UserRequestDto body) {
        final var user = body.toUser();
        user.setId(id);
        return new UserResponseDto(this.userService.saveUser(user));
    }

    @PatchMapping("/{id}")
    private UserResponseDto patch(@PathVariable("id") String id, @RequestBody UserRequestDto body) {
        final var user = this.userService.getById(id);
        body.patchUser(user);
        return new UserResponseDto(this.userService.saveUser(user));
    }

    @GetMapping("/{id}")
    private UserResponseDto getById(@PathVariable("id") String id) {
        return new UserResponseDto(userService.getById(id));
    }

    @DeleteMapping("/{id}")
    private boolean deleteById(@PathVariable("id") String id) {
        userService.deleteById(id);
        return true;
    }
}
