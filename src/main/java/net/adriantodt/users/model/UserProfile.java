package net.adriantodt.users.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserProfile implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
