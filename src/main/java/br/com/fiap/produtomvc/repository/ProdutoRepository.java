package br.com.fiap.produtomvc.repository;

import br.com.fiap.produtomvc.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
