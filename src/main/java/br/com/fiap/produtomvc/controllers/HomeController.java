package br.com.fiap.produtomvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/") //Barra única indica o diretório raiz do projeto - localhost:8080/.
    public String index(Model model) {
        model.addAttribute("msg", "Bem-Vindo(a) à FIAP Developers!");
        return "/produto/index";
    }
}
