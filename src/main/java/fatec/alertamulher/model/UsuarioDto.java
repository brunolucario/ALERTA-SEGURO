package fatec.alertamulher.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class UsuarioDto {
    private Long pkUsuario;

    @Email
    private String emailUsuario;

    @NotBlank
    private String nomeUsuario;

    @NotBlank
    private String telefoneUsuario;
}
