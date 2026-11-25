package br.com.biblioteca.biblioteca.repository;

import br.com.biblioteca.biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
