package fatec.alertamulher.controller;

import fatec.alertamulher.model.Login;
import fatec.alertamulher.service.AcessoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/login")
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AccessoController {

   @Autowired
   public AccessoController(fatec.alertamulher.service.AcessoService service) {
        this.service = service;
    }
    private final AcessoService service;

    @PostMapping
    public String login(@Validated Login login, Model model) {
        String code = service.login(login);
        if (code == null) {
            model.addAttribute("erro", "Usuario nao encontrado");
        } else {
            model.addAttribute("code", code);
        }
        model.addAttribute("content", "login");
        return "main";
    }

    @GetMapping
    public String login(Model model) {
        model.addAttribute("login", new Login());
        model.addAttribute("content", "login");
        return "main";
    }

    @GetMapping("/cadastro")
    public String iniciarCadastro(){
        return "usuario";
    }
}
