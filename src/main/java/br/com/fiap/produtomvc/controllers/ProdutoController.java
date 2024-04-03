package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.models.Categoria;
import br.com.fiap.produtomvc.models.Produto;
import br.com.fiap.produtomvc.repository.CategoriaRepository;
import br.com.fiap.produtomvc.repository.ProdutoRepository;
import br.com.fiap.produtomvc.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

// -- código omitido
//URL - localhost:8080/produtos
@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @ModelAttribute("categorias")
    public List<Categoria> categorias(){
        return categoriaRepository.findAll();
    }

    @GetMapping("/form")
    public String loadForm(Model model) {
        model.addAttribute("produto", new Produto());
        return "produto/novo-produto";
    }

    @PostMapping()
    @Transactional
    public String insert(@Valid Produto produto,
                                BindingResult result,
                                RedirectAttributes attributes) {
        if(result.hasErrors()){
            return "produto/novo-produto";
        }
        service.insert(produto);
        attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso");
        return "redirect:/produtos/form";
    }

    //URL - localhost:8080/produtos/listar
    @GetMapping()
    @Transactional(readOnly = true)
    public String findAll(Model model){
        model.addAttribute("produtos", service.findAll());
        return "/produto/listar-produtos"; //View
    }

    //URL - localhost:8080/produtos/editar/1
    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public String findById(@PathVariable ("id") Long id, Model model ){
        Produto produto = service.findById(id);
        model.addAttribute("produto", produto);
        return "/produto/editar-produto";
    }

    //URL - localhost:8080/produtos/editar/1
    @PutMapping("/{id}")
    @Transactional
    public String update(@PathVariable("id") Long id, @Valid Produto produto,
                                BindingResult result){
        if(result.hasErrors()){
            produto.setId(id);
            return "/produto/editar-produto";
        }
        service.update(id, produto);
        return "redirect:/produtos";
    }

    //URL - localhost:8080/produtos/deletar/1
    @DeleteMapping("/{id}")
    @Transactional
    public String delete(@PathVariable("id") Long id){
        service.delete(id);
        return "redirect:/produtos";
    }
}










