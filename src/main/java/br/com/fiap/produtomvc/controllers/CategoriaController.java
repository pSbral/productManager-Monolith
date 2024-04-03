package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.models.Categoria;
import br.com.fiap.produtomvc.models.Produto;
import br.com.fiap.produtomvc.repository.CategoriaRepository;
import br.com.fiap.produtomvc.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @GetMapping("/form")
    public String loadForm(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria/nova-categoria";
    }

    @PostMapping()
    public String insert(@Valid Categoria categoria,
                         BindingResult result,
                         RedirectAttributes attributes) {
        if(result.hasErrors()){
            return "categoria/nova-categoria";
        }
        service.insert(categoria);
        attributes.addFlashAttribute("mensagem", "Categoria salva com sucesso");
        return "redirect:/categorias/form";
    }

    @GetMapping()
    public String findAll(Model model){
        List<Categoria> categorias = service.findAll();
        model.addAttribute("categorias", categorias);
        return "/categoria/listar-categorias";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model ){
        Categoria categoria = service.findById(id);
        model.addAttribute("categoria", categoria);
        return "/categoria/editar-categoria";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id, @Valid Categoria categoria,
                         BindingResult result){
        if(result.hasErrors()){
            categoria.setId(id);
            return "/categoria/editar-categoria";
        }
        service.update(id, categoria);
        return "redirect:/categorias";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);
        return "redirect:/categorias";
    }
}
