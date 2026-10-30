# Sistema de Cadastro de Autores - Biblioteca

Uma aplicação web desenvolvida em Java com Spring Boot e Thymeleaf para o cadastro de autores no sistema de biblioteca, utilizando o padrão arquitetural MVC (Model-View-Controller).

Este projeto exemplifica o fluxo de recepção de dados via requisições HTTP (GET e POST), vinculação de formulários Thymeleaf (th:object e th:field) e mapeamento para objetos Java no backend com @ModelAttribute.

# Tecnologias Utilizadas

Java 17+

Spring Boot 3.x

Spring Web (Estrutura MVC)

Thymeleaf (Motor de templates HTML)

Maven (Gerenciador de dependências e build)

# Funcionalidades e Rotas

Formulário de Cadastro (GET /autores/novo):

Carrega a view autores/form.html.

Instancia e envia um objeto Autor vazio para binding do formulário.

Processamento do Formulário (POST /autores):

Recebe os dados digitados pelo usuário via @ModelAttribute Autor autor.

Encaminha o objeto preenchido para a página de confirmação (autores/confirmacao.html).

Página de Confirmação:

Exibe dinamicamente os dados do autor recém-cadastrado na interface com Thymeleaf (th:text).

# Estrutura do Repositório

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


# Fluxo da Arquitetura MVC

Acesso: O usuário aciona GET /autores/novo.

Controller: O AutorController cria new Autor() e adiciona ao Model.

View Form: Renderiza autores/form.html permitindo o preenchimento dos campos.

Envio: O formulário submete via POST /autores.

Binding: O Spring associa os campos recebidos aos atributos do objeto Autor.

Confirmação: Renderiza autores/confirmacao.html exibindo os dados processados.

# Como Executar o Projeto

Pré-requisitos

Java 17 ou superior instalado.

Maven (ou utilize o wrapper ./mvnw incluso no projeto).

Passo a passo

Acesse o diretório do projeto Spring Boot:

cd SistemaBiblioteca


Execute o projeto usando o Maven Wrapper:

Linux/macOS:

./mvnw spring-boot:run


Windows:

mvnw.cmd spring-boot:run


Abra o navegador no endereço:

Formulário de Autores: http://localhost:8080/autores/novo
