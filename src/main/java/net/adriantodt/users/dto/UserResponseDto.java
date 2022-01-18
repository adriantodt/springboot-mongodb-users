package net.adriantodt.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.adriantodt.users.model.User;
import net.adriantodt.users.model.UserProfile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponseDto {
    private String id;
    private String nome;
    private String email;
    private String endereco;
    private String telefone;
    private UserProfile perfil;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.endereco = user.getEndereco();
        this.telefone = user.getTelefone();
        this.perfil = user.getPerfil();
    }
}
