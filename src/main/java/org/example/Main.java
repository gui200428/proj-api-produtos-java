package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Eng de Comp - Guilherme Augusto - 05223-071
// Atividade: Criar uma API de Produtos
//Desenvolver uma API de Produtos, conforme o exemplo apresentado em sala de aula.
//A API deverá permitir o cadastro e gerenciamento de produtos, contendo no mínimo os seguintes
//campos:
//• código
//• nome
//• descrição
//• preço
//• quantidade em estoque
//O sistema deve disponibilizar operações para:
//• cadastrar um produto
//• listar todos os produtos
//A API deve ser testada utilizando ferramenta como ThunderClient.
//Desafio extra: implementar validações para impedir cadastro de produtos com campos
//obrigatórios vazios ou preço inválido.

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}