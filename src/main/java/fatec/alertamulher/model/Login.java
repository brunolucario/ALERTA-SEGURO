package fatec.alertamulher.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tbl_login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_login")
    private Long pkLogin;

    @CPF
    private String cpf;

    private String senha;

    private String code;

    private LocalDate dataLogin;

}
