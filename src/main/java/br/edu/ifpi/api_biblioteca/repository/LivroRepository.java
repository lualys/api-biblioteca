package br.edu.ifpi.api_biblioteca.repository;

import br.edu.ifpi.api_biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    // Buscar apenas livros disponíveis
    List<Livro> findByDisponivelTrue();

}