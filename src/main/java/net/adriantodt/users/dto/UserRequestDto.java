package net.adriantodt.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.adriantodt.users.model.User;
import net.adriantodt.users.model.UserProfile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDto {
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private String telefone;
    private UserProfile perfil;

    public User toUser() {
        User user = new User();
        patchUser(user);
        return user;
    }

    public void patchUser(User user) {
        if (this.nome != null) {
            user.setNome(this.nome);
        }
        if (this.email != null) {
            user.setEmail(this.email);
        }
        if (this.senha != null) {
            user.setSenha(this.senha);
        }
        if (this.endereco != null) {
            user.setEndereco(this.endereco);
        }
        if (this.telefone != null) {
            user.setTelefone(this.telefone);
        }
        if (this.perfil != null) {
            user.setPerfil(this.perfil);
        }
    }
}
