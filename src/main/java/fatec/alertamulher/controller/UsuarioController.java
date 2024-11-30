package fatec.alertamulher.controller;

import fatec.alertamulher.model.UsuarioForm;
import fatec.alertamulher.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
//@AllArgsConstructor(onConstructor_ = @__(@Autowired))
public class UsuarioController {

   @Autowired
   public UsuarioController(fatec.alertamulher.service.UsuarioService service, fatec.alertamulher.controller.AccessoController accessoController) {
        this.service = service;
        this.accessoController = accessoController;
    }
    private final UsuarioService service;
    private final AccessoController accessoController;

    @PostMapping
    public String criarUsuario(@Validated UsuarioForm usuarioForm, Model model) {
        boolean sucess = service.criarUsuario(usuarioForm);
        if (sucess) {
            model.addAttribute("sucess", "Usuario criado com sucesso");
        } else {
            model.addAttribute("erro", "Erro ao criar usuario");
        }
        return accessoController.login(model);
    }

    @GetMapping
    public String iniciarCadastro(Model model) {
        model.addAttribute("content", "cadastro");
        model.addAttribute("usuarioForm", new UsuarioForm());

        return "main";
    }
}
