package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.models.Produto;
import br.com.fiap.produtomvc.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//URL - localhost:8080

@Controller //Essa classe é um Controller (Spring)
@RequestMapping("/produtos") //URL - localhost:8080/produtos
public class ProdutoController {

    //Injeção de Dependência
    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/novo")
    public String adicionarProduto(Model model) {
        //DAO
        model.addAttribute("produto", new Produto());
        return "produto/novo-produto";
    }

    @PostMapping("/salvar")
    public String insertProduto(@Valid Produto produto,
                                BindingResult result,
                                RedirectAttributes attributes){
        if (result.hasErrors()){
            return "/produto/novo-produto";
        }
        repository.save(produto);
        attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso");
        return "redirect:/produtos/novo";
    }
}