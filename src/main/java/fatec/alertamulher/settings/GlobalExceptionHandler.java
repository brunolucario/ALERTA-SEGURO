package fatec.alertamulher.settings;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model, WebRequest request) {
        request.setAttribute("errorMessage", e.getMessage(), WebRequest.SCOPE_SESSION);
        return "redirect:/login";
    }
}