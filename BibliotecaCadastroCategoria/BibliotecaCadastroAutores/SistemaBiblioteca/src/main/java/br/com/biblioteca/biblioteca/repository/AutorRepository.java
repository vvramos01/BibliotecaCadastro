package br.com.biblioteca.biblioteca.repository;

import br.com.biblioteca.biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Aula 7: o Spring Data JPA gera a implementação em tempo de execução.
 * Nenhuma linha de SQL é escrita: save(), findAll(), findById(), deleteById()...
 */
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
