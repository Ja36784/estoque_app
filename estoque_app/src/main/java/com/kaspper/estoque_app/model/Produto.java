package com.kaspper.estoque_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Produto é uma entidade, ou seja, ela será mapeada para uma tabela
@Table(name = "produto") // Especifica o nome da tabela no banco de dados que irá armazenar as informações dessa classe.
public class Produto {

    @Id // Define o campo id como a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que o valor do campo id será gerado automaticamente pelo banco de dados
    private Long id;  // A chave primária é do tipo Long, gerada automaticamente;    
    
    private String nome; // nome do produto
    private double preco; // preço do produto
    private int quantidadeEmEstoque; // quantidade de produto em estoque

    // Construtor padrão sem parâmetros para uso do framework de persistência JPA, pois ele precisa pra instanciar a classe de forma automatica
    public Produto() {}

    // Construtor com parâmetros, permite criar um objeto com valores iniciais para os atributos;
    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    // Getters e Setters
    public Long getId() { // get Para acessar
        return id;
    }

    public void setId(Long id) { // set para mofificar
        this.id = id;
    }

    public String getNome() { // get Para acessar
        return nome;
    }

    public void setNome(String nome) { // set para mofificar
        this.nome = nome;
    }

    public double getPreco() { // get Para acessar
        return preco;
    }

    public void setPreco(double preco) { // set para mofificar
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() { // set para mofificar
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) { // get Para acessar
        this.quantidadeEmEstoque = quantidadeEmEstoque; // set para mofificar
    }

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", quantidadeEmEstoque="
				+ quantidadeEmEstoque + ", getId()=" + getId() + ", getNome()=" + getNome() + ", getPreco()="
				+ getPreco() + ", getQuantidadeEmEstoque()=" + getQuantidadeEmEstoque() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	//toString fornecer uma representação legível e detalhada do objeto Produto como uma string. Ele inclui todos os atributos da classe,
	// pois fornece uma visão completa do estado do objeto.
    
    
}
