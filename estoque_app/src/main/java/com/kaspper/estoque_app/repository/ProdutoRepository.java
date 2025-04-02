package com.kaspper.estoque_app.repository;  // Declara o pacote onde a interface ProdutoRepository está localizada

// Importando a classe List para trabalhar com listas de objetos
import java.util.List;

// Importando a interface JpaRepository para estender funcionalidades de repositório
import org.springframework.data.jpa.repository.JpaRepository;
// Importando a anotação Repository para marcar a classe como um repositório do Spring
import org.springframework.stereotype.Repository;

// Importando a classe Produto que será manipulada no repositório
import com.kaspper.estoque_app.model.Produto;

// A anotação @Repository indica que esta interface é um repositório Spring, o que permite que ela seja injetada em outras classes
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    // Método customizado que define uma consulta para buscar produtos pelo nome
    // O Spring Data JPA automaticamente implementa esse método com base no nome do método
    List<Produto> findByNome(String nome);
}
