package fatec.alertamulher.service;

import fatec.alertamulher.model.Usuario;
import fatec.alertamulher.model.UsuarioDto;
import fatec.alertamulher.model.UsuarioForm;
import fatec.alertamulher.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioService {
    private final UsuarioRepository repository;
    private final ModelMapper modelMapper = new ModelMapper();

    public boolean criarUsuario(UsuarioForm usuarioForm) {
        try {
            Usuario usuario = modelMapper.map(usuarioForm, Usuario.class);
            String senha = Base64.getEncoder().withoutPadding().encodeToString(usuario.getSenhaUsuario().getBytes());
            usuario.setSenhaUsuario(senha);
             modelMapper.map(repository.save(usuario), UsuarioDto.class);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
