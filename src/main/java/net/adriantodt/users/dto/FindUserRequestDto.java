package net.adriantodt.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.adriantodt.users.model.UserProfile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FindUserRequestDto {
    private String id;
    private String nome;
    private String email;
    private String endereco;
    private String telefone;
    private UserProfile perfil;
}
