package br.com.biblioteca.biblioteca.repository;

import br.com.biblioteca.biblioteca.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
