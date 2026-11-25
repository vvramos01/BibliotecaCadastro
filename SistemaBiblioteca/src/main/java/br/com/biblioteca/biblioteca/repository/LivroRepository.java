package br.com.biblioteca.biblioteca.repository;

import br.com.biblioteca.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
