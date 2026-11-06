# Sistema de Biblioteca – Cadastro de Autores (Aulas 6 e 7)

Aplicação web em Java com Spring Boot e Thymeleaf (padrão MVC) para cadastro de autores.
Evolução do projeto integrador:

| Aula | O que foi feito |
|------|-----------------|
| 4 | Model `Autor` |
| 5 | Formulário de cadastro (`@ModelAttribute`) |
| 6 | CRUD em memória: `List<Autor>`, listagem com `th:each`, exclusão por índice com `@PathVariable` |
| 7 | **Persistência com H2 + JPA**: `@Entity`, `JpaRepository`, dados sobrevivem ao reinício |

## Tecnologias
Java 17+ · Spring Boot · Spring Web MVC · Thymeleaf · Spring Data JPA · H2 Database · Maven

## Rotas

| Operação | Rota | Implementação (Aula 7) |
|----------|------|------------------------|
| Create (form) | `GET /autores/novo` | exibe `autores/form.html` |
| Create | `POST /autores` | `repository.save(autor)` + `redirect:/autores` |
| Read | `GET /autores` | `repository.findAll()` → `autores/lista.html` (`th:each`) |
| Delete | `GET /autores/excluir/{id}` | `repository.deleteById(id)` + `redirect:/autores` |

> **Update** (editar) fica para a Aula 8.

## Estrutura
```
SistemaBiblioteca/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/br/com/biblioteca/biblioteca/
    │   │   ├── BibliotecaApplication.java
    │   │   ├── controller/AutorController.java
    │   │   ├── model/Autor.java              (@Entity, @Id, @GeneratedValue)
    │   │   └── repository/AutorRepository.java (extends JpaRepository<Autor, Long>)
    │   └── resources/
    │       ├── application.properties        (datasource H2 em arquivo + JPA)
    │       └── templates/autores/
    │           ├── form.html
    │           └── lista.html                (tabela, th:each, contador)
    └── test/ (H2 em memória para os testes)
```

## Como a Aula 6 virou a Aula 7

| | Aula 6 (memória) | Aula 7 (banco) |
|---|---|---|
| Armazenamento | `private List<Autor> autores = new ArrayList<>();` | `AutorRepository` (injetado por construtor) |
| Cadastrar | `autores.add(autor)` | `repository.save(autor)` |
| Listar | `model.addAttribute("autores", autores)` | `model.addAttribute("autores", repository.findAll())` |
| Excluir | `autores.remove(indice)` com `status.index` | `repository.deleteById(id)` com o ID único do banco |
| Dados após reiniciar | perdidos | **mantidos** |

O índice da lista não serve como identificador (muda a cada exclusão – "Erro comum 2" da Aula 6),
por isso a exclusão passou a usar o `id` gerado pelo banco.
A View Thymeleaf continua recebendo a mesma lista de `Autor`.

## Como executar
Pré-requisito: Java 17+ (o Maven Wrapper já está incluso).

```bash
cd SistemaBiblioteca
./mvnw spring-boot:run        # Linux/macOS
mvnw.cmd spring-boot:run      # Windows
```

Acesse:
- Cadastro: http://localhost:8080/autores/novo
- Listagem: http://localhost:8080/autores

## Teste de validação (roteiro da Aula 7)
1. Cadastre 4 autores (ex.: J.R.R. Tolkien – Britânica; Robert C. Martin – Americano; Machado de Assis – Brasileira; George Orwell – Britânica).
2. Exclua 1 autor e confira o "Total de autores".
3. Pare o servidor (Ctrl+C) e inicie novamente.
4. Abra `/autores`: os autores restantes **continuam lá**.

Os dados ficam no arquivo `SistemaBiblioteca/data/biblioteca.mv.db` (ignorado pelo Git).
Para zerar o banco, pare a aplicação e apague a pasta `data/`.

## Observações
- A URL `jdbc:h2:file:./data/biblioteca` é **em arquivo**; com `jdbc:h2:mem:` os dados se perderiam ao reiniciar.
- Trocar H2 por MySQL no futuro exige mudar apenas dependência e `application.properties`;
  Controller e Repository permanecem iguais.
- A exclusão via `GET` segue o padrão visto em aula; em produção o ideal seria `POST`/`DELETE`.
