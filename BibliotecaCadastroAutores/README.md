# Cadastro de Autores

Rotas:
- `GET /autores/novo` formulário
- `POST /autores` salva o autor
- `GET /autores` lista os autores
- `GET /autores/excluir/{id}` exclui pelo id

Rodar: `./mvnw spring-boot:run` e abrir http://localhost:8080/autores

O banco H2 fica em arquivo (`data/`), então os autores continuam depois de reiniciar.
