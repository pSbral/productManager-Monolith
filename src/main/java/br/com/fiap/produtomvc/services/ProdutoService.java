package br.com.fiap.produtomvc.services;

import br.com.fiap.produtomvc.models.Categoria;
import br.com.fiap.produtomvc.models.Produto;
import br.com.fiap.produtomvc.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto insert(Produto produto) {
        return repository.save(produto);
    }

    @Transactional(readOnly = true)
    public List<Produto> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Produto findById(Long id){
        Produto produto = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso invalido - " + id)
        );
        return produto;
    }

    private void copytoProduto(Produto entity, Produto produto) {
        produto.setNome(entity.getNome());
    }

    @Transactional
    public Produto update(Long id, Produto entity) {
        try{
            Produto produto = repository.getReferenceById(id);
            copytoProduto(entity, produto);
            produto = repository.save(produto);
            return produto;
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Recurso não encontrado.");
        }
    }

    @Transactional
    public void delete(Long id){
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Recurso invalido - " + id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Falha na integridade referencial - id:" + id);
        }
    }
}
