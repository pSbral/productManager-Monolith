package br.com.fiap.produtomvc.repository;

import br.com.fiap.produtomvc.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
