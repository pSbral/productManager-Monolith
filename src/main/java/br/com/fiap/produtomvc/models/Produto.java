package br.com.fiap.produtomvc.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Objects;

// Identifica que essa classe a ser modelada por um banco de dados.
//@Table identifica a tabela que será usada para armazenar esse tipo de dado.
@Entity
@Table(name = "tb_produto")
public class Produto {
    // @Id identifica a Primary Key, enquanto @GenaretedValue gera automaticamente um identificador.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Campo Requerido")
    @Size(min = 3, message = "O nome dete ter no minimo 3 caracteres")
    private String nome;
    @NotBlank(message = "Campo Requerido")
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @NotNull(message = "Campo Requerido")
    @Positive(message = "O valor deve ser positivo")
    private Double valor;

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, Double valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }
}
