# Sistema de Cadastro de Acervo - Biblioteca

Uma aplicação web robusta para cadastro e gestão de livros, desenvolvida em Java com Spring Boot e Thymeleaf, utilizando a arquitetura MVC (Model-View-Controller).

Este projeto foi desenvolvido como parte prática dos conceitos de desenvolvimento web Server-Side Rendering (SSR), cobrindo requisições HTTP (GET e POST), binding de formulários com @ModelAttribute, e manipulação dinâmica de templates HTML.

# Tecnologias Utilizadas

Java 17+

Spring Boot 3.x

Spring Web (Estrutura MVC)

Spring Boot DevTools (Agilidade no desenvolvimento)

Thymeleaf (Engine de templates HTML)

HTML5 & CSS3 (Interface responsiva e estilizada)

Maven (Gerenciamento de dependências e build)

# Funcionalidades

Formulário de Cadastro (GET /livros/novo):

Exibição do formulário integrado a um objeto Livro vazio via th:object.

Mapeamento dinâmico de campos com th:field (titulo, autor, isbn, anoPublicacao, editora, genero).

Processamento de Dados (POST /livros/cadastrar):

Recebimento e associação automática dos dados do formulário via @ModelAttribute.

Página de Confirmação:

Exibição clara e estilizada das informações recebidas e processadas pelo servidor.

# Estrutura do Projeto

BibliotecaCadastro/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/com/biblioteca/app/
│   │   │       ├── BibliotecaApplication.java
│   │   │       ├── controller/
│   │   │       │   └── LivroController.java
│   │   │       └── model/
│   │   │           └── Livro.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/
│   │           └── livros/
│   │               ├── formulario-cadastro.html
│   │               └── confirmacao-cadastro.html
│   └── test/
│       └── java/
│           └── br/com/biblioteca/app/
│               └── BibliotecaApplicationTests.java
├── pom.xml
└── README.md


# Fluxo da Arquitetura MVC

Requisição GET: O usuário acessa /livros/novo. O LivroController instancia um objeto Livro e encaminha a view formulario-cadastro.html.

Preenchimento do Formulário: O formulário Thymeleaf vincula cada input ao atributo do objeto Livro.

Submissão POST: Ao enviar o formulário, os dados entram na rota /livros/cadastrar. O Spring converte os campos no objeto Java Livro.

Renderização de Confirmação: O Controller repassa o objeto preenchido para a página confirmacao-cadastro.html, exibindo o resumo dos dados cadastrados.

# Como Executar o Projeto

Pré-requisitos

Java 17 ou superior instalado.

Maven instalado (ou utilizar o wrapper da IDE).

Git configurado.

Passo a passo

Clonar o repositório:

git clone https://github.com/seu-usuario/BibliotecaCadastro.git
cd BibliotecaCadastro


Executar a aplicação:

Via linha de comando (terminal):

./mvnw spring-boot:run


Ou executando a classe BibliotecaApplication.java diretamente na sua IDE (IntelliJ IDEA, Eclipse, VS Code).

Acessar a aplicação no navegador:

Formuário de Cadastro: http://localhost:8080/livros/novo
