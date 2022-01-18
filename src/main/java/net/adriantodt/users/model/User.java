package net.adriantodt.users.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
@QueryEntity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    private String id;

    @Field
    private String nome;

    @Field
    private String email;

    @Field
    private String senha;

    @Field
    private String endereco;

    @Field
    private String telefone;

    @Field
    private UserProfile perfil;
}
