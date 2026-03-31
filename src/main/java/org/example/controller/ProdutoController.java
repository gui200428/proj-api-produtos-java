package org.example.controller;

import org.example.model.Produto;
import org.example.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarTodos(){
        return produtoService.listarTodos();
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        Produto novoProduto = produtoService.adicionar(produto);
        return novoProduto;
    }

}
