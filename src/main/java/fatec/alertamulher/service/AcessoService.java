package fatec.alertamulher.service;

import fatec.alertamulher.model.Login;
import fatec.alertamulher.model.Usuario;
import fatec.alertamulher.repository.AcessoRepository;
import fatec.alertamulher.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Optional;

@Service
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AcessoService {

    @Autowired
    public AcessoService(fatec.alertamulher.repository.AcessoRepository repository, fatec.alertamulher.repository.UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }
    private final AcessoRepository repository;
    private final UsuarioRepository usuarioRepository;

    public String login(Login login) {
        try {
            String senha = encodeSenha(login.getSenha());
            Optional<Usuario> usuario = usuarioRepository.findByCpfUsuarioAndSenhaUsuario(login.getCpf(), senha);
            if (usuario.isPresent()) {

                var random = SecureRandom.getInstanceStrong();
                String code = Base64.getEncoder().withoutPadding().encodeToString(random.toString().getBytes());
                login.setCode(code);
                login.setDataLogin(LocalDate.now());
                repository.save(login);
                return code;
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private String encodeSenha(String senha) {
        return Base64.getEncoder().withoutPadding().encodeToString(senha.getBytes());
    }
}
