package net.adriantodt.users.controller;

import lombok.RequiredArgsConstructor;
import net.adriantodt.users.dto.FindUsersRequestDto;
import net.adriantodt.users.dto.FindUsersResponseDto;
import net.adriantodt.users.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Objects;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UserService userService;

    @GetMapping()
    public FindUsersResponseDto list(
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "size", required = false) Integer size
    ) {
        final var results = userService.findUsers(
            null,
            Objects.requireNonNullElse(page, 0),
            Objects.requireNonNullElse(size, 10),
            Collections.emptyList()
        );

        return new FindUsersResponseDto(results);
    }

    @PostMapping()
    public FindUsersResponseDto find(@RequestBody FindUsersRequestDto body) {
        final var results = userService.findUsers(
            body.getParams(),
            Objects.requireNonNullElse(body.getCurrentPage(), 0),
            Objects.requireNonNullElse(body.getPaginationSize(), 10),
            Objects.requireNonNullElse(body.getOrderBy(), Collections.emptyList())
        );

        return new FindUsersResponseDto(results);
    }
}
