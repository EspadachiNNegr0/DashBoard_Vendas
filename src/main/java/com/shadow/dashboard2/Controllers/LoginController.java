package com.shadow.dashboard2.Controllers;

import com.shadow.dashboard2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/Login")
    public String loginPage(Model model) {
        // Retorna a página de login
        return "login/login";  // A página HTML de login dentro da pasta "login"
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        // Usando o serviço para autenticar
        boolean isAuthenticated = userService.authenticate(username, password);

        if (isAuthenticated) {
            // Se a autenticação for bem-sucedida, redireciona para o dashboard
            return "redirect:/Dash";  // A URL do dashboard após o login bem-sucedido
        } else {
            // Se a autenticação falhar, retorna à página de login com uma mensagem de erro
            model.addAttribute("error", "Invalid username or password");
            return "login/login";  // Redireciona para a página de login com a mensagem de erro
        }
    }
}
