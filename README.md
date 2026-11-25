# Cadastro de Autores — Sistema de Biblioteca

Aplicação web simples feita em Java com Spring Boot e Thymeleaf para cadastrar autores no sistema da biblioteca usando MVC.

A ideia aqui foi praticar o fluxo de envio de formulários HTML com Thymeleaf (`th:object`, `th:field` e `th:text`), recebendo os dados no controller com `@ModelAttribute` nas rotas `GET` e `POST`.

## Stack

- Java 17+
- Spring Boot 3.x
- Spring Web
- Thymeleaf
- Maven

## Rotas e telas

- **`GET /autores/novo`**: cria um `Autor` vazio no model e abre `autores/form.html`.
- **`POST /autores`**: recebe o objeto preenchido via `@ModelAttribute Autor autor` e manda para `autores/confirmacao.html`.
- **Confirmação**: mostra na tela os dados que foram enviados usando `th:text`.

## Estrutura de pastas

```text
BibliotecaCadastro/
├── README.md
└── SistemaBiblioteca/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── br/com/biblioteca/biblioteca/
    │   │   │       ├── BibliotecaApplication.java
    │   │   │       ├── controller/
    │   │   │       │   └── AutorController.java
    │   │   │       └── model/
    │   │   │           └── Autor.java
    │   │   └── resources/
    │   │       ├── application.properties
    │   │       └── templates/
    │   │           └── autores/
    │   │               ├── form.html
    │   │               └── confirmacao.html
    │   └── test/
    │       └── java/
    │           └── br/com/biblioteca/biblioteca/
    │               └── BibliotecaApplicationTests.java
    ├── mvnw
    ├── mvnw.cmd
    └── pom.xml
