# Sistema de Biblioteca - CRUD de Livros

Rotas:
- `GET /livros/novo` formulário de cadastro
- `POST /livros` salva (cadastra ou atualiza, depende do id)
- `GET /livros` lista os livros
- `GET /livros/editar/{id}` abre o formulário preenchido
- `GET /livros/excluir/{id}` exclui pelo id

Rodar: `./mvnw spring-boot:run` e abrir http://localhost:8080/livros

Teste: editar um livro, excluir outro, parar a aplicação, iniciar de novo e ver se a lista continua igual.
