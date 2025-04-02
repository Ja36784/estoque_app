package com.kaspper.estoque_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstoqueAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EstoqueAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Esta classe apenas inicia a aplicação
        // Você pode rodar qualquer lógica inicial aqui, se necessário
        System.out.println("Aplicação iniciada com sucesso!");
    }
}
