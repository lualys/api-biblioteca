package br.edu.ifpi.api_biblioteca.controller;

import br.edu.ifpi.api_biblioteca.model.Livro;
import br.edu.ifpi.api_biblioteca.service.LivroService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    // POST - Cadastrar livro
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro cadastrar(@RequestBody Livro livro) {
        return service.cadastrar(livro);
    }

    // GET - Listar todos os livros
    @GetMapping
    public List<Livro> listar() {
        return service.listar();
    }

    // GET - Listar livros disponíveis
    @GetMapping("/disponiveis")
    public List<Livro> listarDisponiveis() {
        return service.listarDisponiveis();
    }

    // GET - Buscar livro pelo ID
    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}