package fatec.alertamulher.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@Entity
@Table(name = "tbl_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_usuario")
    private Long pkUsuario;

    @Email
    @Column(nullable = false, name = "email_usuario")
    private String emailUsuario;

    @NotBlank
    @Column(nullable = false, name = "nome_usuario")
    private String nomeUsuario;

    @CPF
    @Column(nullable = false, name = "cpf_usuario",length = 11)
    private String cpfUsuario;

    @NotBlank
    @Column(nullable = false, name = "telefone_usuario",length = 11)
    private String telefoneUsuario;

    @NotBlank
    @Column(nullable = false,name = "senha_usuario")
    private String senhaUsuario;
}
