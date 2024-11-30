package fatec.alertamulher.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class UsuarioForm {

    @Email
    private String emailUsuario;

    @NotBlank
    private String nomeUsuario;

    @CPF
    private String cpfUsuario;

    @NotBlank
    private String telefoneUsuario;

    @NotBlank
    private String senhaUsuario;
}
