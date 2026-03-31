package org.example.service;

import org.example.model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private final List<Produto> produtos = new ArrayList<>();

    public ProdutoService(){
        produtos.add(new Produto(1L, "TV", "Tv 90 polegadas", 7999.00, 123));
        produtos.add(new Produto(2L, "Geladeira", "Geladeira eletrolux", 3799.00, 15));
        produtos.add(new Produto(3L, "Bicicleta", "Bicicleta de 2 rodas", 750.00, 150));
        produtos.add(new Produto(4L, "Ar condicionado", "Descrição", 999.00, 150));
    }

    public List<Produto> listarTodos(){
        return produtos;
    }
    // Desafio extra: implementar validações para impedir cadastro de produtos com campos obrigatórios vazios ou preço inválido.
    public Produto adicionar(Produto produto){
        if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo: nome é obrigatório.");
        }
        if (produto.getDescricao() == null || produto.getDescricao().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo: descrição é obrigatório.");
        }
        if (produto.getPreco() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo: preço é obrigatório.");
        }
        if (produto.getPreco() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo: preço deve ser maior que zero.");
        }
        if (produto.getQuantidadeEmEstoque() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo: quantidade em estoque é obrigatório.");
        }
        if (produto.getQuantidadeEmEstoque() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo: quantidade em estoque não pode ser negativo.");
        }

        Long novoCodigo = (long) (produtos.size() + 1);
        produto.setCodigo(novoCodigo);
        produtos.add(produto);
        return produto;
    }
}
