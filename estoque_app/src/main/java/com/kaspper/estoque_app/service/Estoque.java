package com.kaspper.estoque_app.service;

import com.kaspper.estoque_app.model.Produto;
import com.kaspper.estoque_app.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service  // Anotação que define a classe como um serviço no Spring
public class Estoque {

    @Autowired  // Injeção de dependência para o repositório de produtos
    private ProdutoRepository produtoRepository; // é uma interface que provavelmente extende ao JpaRepository, 
    //que fornece métodos prontos para realizar operações CRUD, no banco de dados para a entidade Produto

    // Método para adicionar produto ao estoque
    public Produto adicionarProduto(Produto produto) {
        // Chama o método 'save' do repositório para salvar o produto no banco de dados
        return produtoRepository.save(produto);  // Retorna o produto salvo com o ID gerado
    }

    // Método para remover produto pelo nome
    public void removerProduto(String nome) {
        // Busca todos os produtos com o nome informado
        List<Produto> produtos = produtoRepository.findByNome(nome);
        
        // Verifica se a lista de produtos está vazia
        if (produtos.isEmpty()) {
            // Se não encontrar produtos, lança uma exceção com o status 404 (não encontrado)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
        }
        
        // Se encontrar produtos com o nome, remove todos eles
        produtoRepository.deleteAll(produtos);
    }

    // Método para atualizar a quantidade de um produto
    public Produto atualizarQuantidadeProduto(String nome, int novaQuantidade) {
        // Busca todos os produtos com o nome informado
        List<Produto> produtos = produtoRepository.findByNome(nome);
        
        // Verifica se algum produto foi encontrado
        if (!produtos.isEmpty()) {
            // Se encontrar, escolhe o primeiro produto da lista (caso haja mais de um com o mesmo nome)
            Produto produto = produtos.get(0);
            
            // Atualiza a quantidade em estoque do produto
            produto.setQuantidadeEmEstoque(novaQuantidade);
            
            // Salva novamente o produto no banco de dados com a quantidade atualizada
            return produtoRepository.save(produto);
        }
        
        // Se nenhum produto for encontrado, retorna null
        return null;
    }

    // Método para calcular o valor total do estoque
    public double calcularValorTotal() {
        // Recupera todos os produtos do banco de dados
        List<Produto> produtos = produtoRepository.findAll();
        
        double total = 0;
        
        // Para cada produto no estoque, calcula o valor total
        for (Produto produto : produtos) {
            total += produto.getPreco() * produto.getQuantidadeEmEstoque();
        }
        
        // Retorna o valor total do estoque
        return total;
    }

    // Expor o valor total do estoque como um endpoint (simplificando o acesso ao valor total)
    public double getValorTotalEstoque() {
        // Chama o método calcularValorTotal e retorna o valor total
        return calcularValorTotal();
    }

    // Método para listar todos os produtos no estoque
    public List<Produto> listarProdutos() {
        // Retorna a lista de todos os produtos no banco de dados
        return produtoRepository.findAll();
    }

    // Método para calcular o valor total (duplicado do anterior)
    public double calcularValorTotal1() {
        // Recupera todos os produtos do banco de dados
        List<Produto> produtos = produtoRepository.findAll();
        
        double total = 0;
        
        // Para cada produto, soma o valor de cada um com base no preço e na quantidade em estoque
        for (Produto produto : produtos) {
            total += produto.getPreco() * produto.getQuantidadeEmEstoque();
        }
        
        // Retorna o valor total
        return total;
    }

}
