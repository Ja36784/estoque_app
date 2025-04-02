package com.kaspper.estoque_app.controller;  // Define o pacote onde o controlador está localizado

// Importando a classe Produto que representa os dados de um produto
import com.kaspper.estoque_app.model.Produto;
// Importando o serviço Estoque que contém a lógica de negócio para gerenciar os produtos
import com.kaspper.estoque_app.service.Estoque;
// Importando o Logger para registrar informações de log
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// Importando as anotações do Spring para controlar as requisições HTTP
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// A anotação @RestController indica que esta classe é responsável por lidar com requisições REST (não retorna páginas, mas dados).
// A anotação @RequestMapping("/api/estoque") define a URL base para todos os endpoints dessa classe ("/api/estoque").
@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    // Criando um Logger para registrar eventos e erros
    private static final Logger logger = LoggerFactory.getLogger(EstoqueController.class);

    // A anotação @Autowired injeta automaticamente a dependência do serviço Estoque
    @Autowired
    private Estoque estoque;

    // Endpoint para adicionar um produto ao estoque
    // A anotação @PostMapping mapeia requisições HTTP POST para o método
    // O @RequestBody indica que o corpo da requisição conterá um objeto Produto em formato JSON
    @PostMapping("/adicionar")
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto) {
        // Registrando uma mensagem de log informando que está tentando adicionar um produto
        logger.info("Tentando adicionar produto: {}", produto.getNome());
        // Chama o serviço Estoque para adicionar o produto
        Produto produtoSalvo = estoque.adicionarProduto(produto);
        // Registrando uma mensagem de log indicando que o produto foi adicionado com sucesso
        logger.info("Produto adicionado com sucesso: {}", produtoSalvo.getNome());
        // Retorna uma resposta HTTP com o produto adicionado e o status HTTP 201 (Criado)
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }

    // Endpoint para remover um produto pelo nome
    // A anotação @DeleteMapping mapeia requisições HTTP DELETE para o método
    // O @PathVariable extrai o parâmetro 'nome' diretamente da URL da requisição
    @DeleteMapping("/remover/{nome}")
    public ResponseEntity<Void> removerProduto(@PathVariable String nome) {
        // Chama o serviço Estoque para remover o produto pelo nome
        estoque.removerProduto(nome);
        // Retorna uma resposta HTTP 204 (No Content), indicando que a operação foi bem-sucedida mas sem conteúdo na resposta
        return ResponseEntity.noContent().build();
    }

    // Endpoint para atualizar a quantidade de um produto
    // A anotação @PutMapping mapeia requisições HTTP PUT para o método
    // O @PathVariable extrai o parâmetro 'nome' diretamente da URL
    // O @RequestParam é usado para extrair o valor do parâmetro 'novaQuantidade' da query string da URL
    @PutMapping("/atualizar/{nome}")
    public ResponseEntity<Produto> atualizarQuantidadeProduto(@PathVariable String nome, @RequestParam int novaQuantidade) {
        // Chama o serviço Estoque para atualizar a quantidade do produto
        Produto produtoAtualizado = estoque.atualizarQuantidadeProduto(nome, novaQuantidade);
        // Se o produto for encontrado e a quantidade for atualizada com sucesso, retorna o produto atualizado
        if (produtoAtualizado != null) {
            return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);  // Retorna o produto com status 200 (OK)
        } else {
            // Se o produto não for encontrado, retorna uma resposta 404 (Não encontrado)
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para calcular o valor total do estoque
    // A anotação @GetMapping mapeia requisições HTTP GET para o método
    @GetMapping("/valor-total")
    public ResponseEntity<Double> calcularValorTotal() {
        // Chama o serviço Estoque para calcular o valor total do estoque
        double valorTotal = estoque.calcularValorTotal();
        // Retorna o valor total do estoque com status HTTP 200 (OK)
        return new ResponseEntity<>(valorTotal, HttpStatus.OK);
    }

    // Endpoint para listar todos os produtos do estoque
    // A anotação @GetMapping mapeia requisições HTTP GET para o método
    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> listarProdutos() {
        // Chama o serviço Estoque para listar todos os produtos no estoque
        List<Produto> produtos = estoque.listarProdutos();
        // Retorna a lista de produtos com status HTTP 200 (OK)
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
}
