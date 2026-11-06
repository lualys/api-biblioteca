package br.edu.ifpi.api_biblioteca.service;

import br.edu.ifpi.api_biblioteca.model.Livro;
import br.edu.ifpi.api_biblioteca.repository.LivroRepository;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }


    public Livro cadastrar(Livro livro) {
        livro.setId(null);
        return repository.save(livro);
    }

   
    public List<Livro> listar() {
        return repository.findAll();
    }

    public Livro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Livro não encontrado com ID: " + id
                ));
    }

    public List<Livro> listarDisponiveis() {
        return repository.findByDisponivelTrue();
    }
}