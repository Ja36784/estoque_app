package com.kaspper.estoque_app.controller;  // Declara o pacote onde a classe PageController está localizada

// Importando a anotação Controller do Spring para marcar a classe como um controlador de páginas
import org.springframework.stereotype.Controller;
// Importando a anotação GetMapping para mapear as requisições HTTP GET
import org.springframework.web.bind.annotation.GetMapping;

// A anotação @Controller indica que esta classe é um controlador Spring, responsável por gerenciar as páginas da aplicação.
@Controller
public class PageController {

    // A anotação @GetMapping mapeia a URL "/" para este método
    // Quando o usuário acessar a raiz ("/") da aplicação, o método mostrarPagina será chamado
    @GetMapping("/")
    public String mostrarPagina() {
        // Retorna o nome da página a ser exibida. Neste caso, a página "produtos.html".
        // O Spring automaticamente procura por arquivos de template com o nome fornecido.
        return "produtos";  // Retorna a página "produtos.html"
    }
}
